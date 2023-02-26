package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.exception.EmailAlreadyExistsException;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IUserPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
class UserUseCaseTest {
    @Mock
    private IUserPersistencePort userPersistencePort;
    @InjectMocks
    private UserUseCase userUseCaseMock;

    @Nested
    class saveUser {
        @Test
        @DisplayName("success")
        void saveUserSuccess() {
            UserModel userMock = new UserModel(1L, "12334"
                    , "Pepe", "Veaz", "662763"
                    , "notieneq@gmail.com", "egeuue", 1L);
            Mockito.when(userPersistencePort.saveUser(any()))
                    .thenReturn(new UserModel());
            userUseCaseMock.saveUser(userMock);

            Mockito.verify(userPersistencePort, Mockito.times(1))
                    .saveUser(userMock);
        }

        @Test
        @DisplayName("EmailAlreadyExists")
        void saveUserEmailAlreadyExists() {
            UserModel userMock = new UserModel(1L, "12334"
                    , "Pepe", "Veaz", "6627637878789"
                    , "notieneq@gmail.com", "egeuue", 1L);

            Mockito.when(userPersistencePort.findOneByEmail(any()))
                            .thenReturn(userMock);

            Assertions.assertThrows(EmailAlreadyExistsException.class,
                    () -> userUseCaseMock.saveUser(userMock));
        }


        @Test
        @DisplayName("PhoneError")
        void saveUserPhoneError() {
            UserModel userMock = new UserModel(1L, "12334"
                    , "Pepe", "Veaz", "6627637878789"
                    , "notieneq@gmail.com", "egeuue", 1L);

            Assertions.assertThrows(NoDataFoundException.class,
                    () -> userUseCaseMock.saveUser(userMock));
        }

        @Test
        @DisplayName("documentError")
        void saveUserDocumentError() {
            UserModel userMock = new UserModel(1L, "12g334"
                    , "Pepe", "Veaz", "662763"
                    , "notieneq@gmail.com", "egeuue", 1L);

            Assertions.assertThrows(NoDataFoundException.class,
                    () -> userUseCaseMock.saveUser(userMock));
        }

        @Test
        @DisplayName("emailError")
        void saveUserEmailError() {
            UserModel userMock = new UserModel(1L, "12334"
                    , "Pepe", "Veaz", "662763"
                    , "notieneqgmail.com", "egeuue", 1L);

            Assertions.assertThrows(NoDataFoundException.class,
                    () -> userUseCaseMock.saveUser(userMock));
        }
    }
    @Test
    void findByID() {
        UserModel userMock = new UserModel(1L, "12334"
               , "Pepe", "Veaz", "662763"
               , "notieneq@gmail.com", "egeuue", 1L);
        Mockito.when(userPersistencePort.findByID(anyLong()))
              .thenReturn(userMock);

        UserModel user = userUseCaseMock.findByID(1L);

        assertEquals(userMock, user);
    }
}