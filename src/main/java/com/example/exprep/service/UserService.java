package com.example.exprep.service;

import com.example.exprep.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
