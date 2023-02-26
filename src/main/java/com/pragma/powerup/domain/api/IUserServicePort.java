package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserServicePort {
    void saveUser(UserModel user);

    List<UserModel> getAllUsers();

    UserModel findByID(Long id);

}
