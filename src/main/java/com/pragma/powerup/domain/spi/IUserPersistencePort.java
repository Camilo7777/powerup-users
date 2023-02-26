package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.UserModel;


import java.util.List;

public interface IUserPersistencePort {
    UserModel saveUser(UserModel user);
    UserModel findByID(Long id);

    UserModel getUserByDocumentNumber(String documentNumber);

    UserModel findOneByEmail(String email);
    UserModel findOneByPassword(String password);
    UserModel getUserByEmailAndPassword(String email, String password);
    List<UserModel> getAllUsers();
}
