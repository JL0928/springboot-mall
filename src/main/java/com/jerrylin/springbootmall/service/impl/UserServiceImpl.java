package com.jerrylin.springbootmall.service.impl;

import com.jerrylin.springbootmall.dao.UserDao;
import com.jerrylin.springbootmall.dto.UserRegisterRequest;
import com.jerrylin.springbootmall.modal.User;
import com.jerrylin.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }
}
