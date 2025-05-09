package com.jerrylin.springbootmall.dao;

import com.jerrylin.springbootmall.dto.UserRegisterRequest;
import com.jerrylin.springbootmall.modal.User;

public interface UserDao {

    int createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(int userId);

    User getUserByEmail(String email);
}
