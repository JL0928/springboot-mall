package com.jerrylin.springbootmall.service;

import com.jerrylin.springbootmall.dto.UserRegisterRequest;
import com.jerrylin.springbootmall.modal.User;

public interface UserService {

    int register(UserRegisterRequest userRegisterRequest);

    User getUserById(int userId);
}
