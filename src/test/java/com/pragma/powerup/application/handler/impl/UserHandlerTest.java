package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.UserResponseDto;
import com.pragma.powerup.application.mapper.IUserRequestMapper;
import com.pragma.powerup.application.mapper.IUserResponseMapper;
import com.pragma.powerup.domain.api.IUserServicePort;
import com.pragma.powerup.domain.model.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(SpringExtension.class)
class UserHandlerTest {
    @Mock
    private  IUserServicePort userServicePort;

    @Mock
    private  IUserRequestMapper userRequestMapper;

    @Mock
    private  IUserResponseMapper userResponseMapper;

    @InjectMocks
    private UserHandler userHandlerMock;

    @Test
    void saveUser() {
        UserRequestDto userRequestDtoMock =  UserRequestDto.builder()
                .id(1L)
                .id(2L)
                .phone("234")
                .email("sitiene@gmail.com")
                .documentNumber("12345")
                .fistName("Pepe")
                .lastName("Orozco")
                .password("dfsghjd")
                .build();

        Mockito.when(userRequestMapper.toUser(any()))
                        .thenReturn(new UserModel());

        Mockito.doNothing()
                .when(userServicePort).saveUser(any());

        userHandlerMock.saveUser(userRequestDtoMock);
        Mockito.verify(userServicePort,Mockito.times(1))
                .saveUser(any());

    }

    /*

    @Test
    void findByID() {

        UserResponseDto userResponseDto =  UserResponseDto.builder()
                .id(1L)
                .idRol(2L)
                .phone("234")
                .email("sitiene@gmail.com")
                .documentNumber("12345")
                .fistName("Pepe")
                .lastName("Orozco")
                .password("dfsghjd")
                .build();

        Mockito.when(userServicePort.findByID(anyLong()))
                .thenReturn(new UserModel());

        Mockito.when(userResponseMapper.toUserResponseDto(any()))
                .thenReturn(userResponseDto);

        UserResponseDto result = userHandlerMock.findByID(1L);

        Assertions.assertEquals(1L,result.getId());




    }

     */
}