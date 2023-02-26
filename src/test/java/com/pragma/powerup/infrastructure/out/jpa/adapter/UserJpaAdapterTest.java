package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.application.dto.response.UserResponseDto;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.Assertions;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
class UserJpaAdapterTest {

    @Mock
    private  IUserRepository userRepositoryMock;
    @Mock
    private  IUserEntityMapper entityMapperMock;
    @Mock
    private  PasswordEncoder passwordEncoderMock;

    @InjectMocks
    UserJpaAdapter userJpaAdapterMock;


    /*
    @Test
    void saveUser() {
        UserModel userModelMock = new UserModel(1L,"1234","Pepe"
        ,"veraz","12345","notiene@gmail.com"
                ,"123456",2L);

        UserEntity userEntityMock = new UserEntity(1L,"1234",
                "pepe","veraz","234567","sitiene@gmail.com","34567",2L);


        Mockito.when(entityMapperMock.toEntity(any()))
                        .thenReturn(userEntityMock);

        Mockito.when(userRepositoryMock.save(any()))
                .thenReturn(userEntityMock);

        Mockito.when(entityMapperMock.toUserModel(any()))
                .thenReturn(userModelMock);

        UserModel userModel = userJpaAdapterMock.saveUser(userModelMock);


        assertEquals(1L,userModel.getId());

    }


     */

    /*
    @Test
    void findByID() {

        UserEntity userEntityMock = new UserEntity(1L,"1234",
                "pepe","veraz","234567","sitiene@gmail.com","34567",2L);

        UserModel userModelMock = new UserModel(1L,"1234","Pepe"
                ,"veraz","12345","notiene@gmail.com"
                ,"123456",2L);

        Mockito.when(userRepositoryMock.findById(anyLong()))
                .thenReturn(java.util.Optional.of(userEntityMock));

        Mockito.when(entityMapperMock.toUserModel(any()))
                        .thenReturn(userModelMock);

       UserModel model = userJpaAdapterMock.findByID(1L);

        assertEquals(1L,model.getId());


    }

     */
}