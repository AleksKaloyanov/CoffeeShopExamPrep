package com.example.exprep.service;

import com.example.exprep.model.entity.UserEntity;
import com.example.exprep.model.service.UserServiceModel;
import com.example.exprep.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    UserEntity findById(Long id);

    List<UserViewModel> findAllUsersAndCountOfOrdersOrderByCountDesc();
}
