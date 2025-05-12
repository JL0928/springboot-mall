package com.jerrylin.springbootmall.service.impl;

import com.jerrylin.springbootmall.dao.UserDao;
import com.jerrylin.springbootmall.dto.UserLonginRequest;
import com.jerrylin.springbootmall.dto.UserRegisterRequest;
import com.jerrylin.springbootmall.modal.User;
import com.jerrylin.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public int register(UserRegisterRequest userRegisterRequest) {
        //檢查註冊的 email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if(user != null){
            log.warn("該 email {} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //使用 MD5 生成密碼雜湊值
        String hashPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashPassword);

        //創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(int userId) {

        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLonginRequest userLonginRequest) {
        User user = userDao.getUserByEmail(userLonginRequest.getEmail());

        //檢查User是否存在
        if(user == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //使用 MD5 生成密碼的雜湊值
        String hashPassword = DigestUtils.md5DigestAsHex(userLonginRequest.getPassword().getBytes());


        //比較密碼
        if(user.getPassword().equals(hashPassword)){
            return user;
        }else{
            log.warn("email {} 的密碼不正確",userLonginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
