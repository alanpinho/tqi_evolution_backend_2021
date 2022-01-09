package com.evolution.tqi.app.register_user.service;

import com.evolution.tqi.app.register_user.model.UserModel;
import com.evolution.tqi.app.register_user.repository.UserRepository;
import com.evolution.tqi.app.register_user.request.UserModelPostRequestBody;
import com.evolution.tqi.app.register_user.response.UserModelPostResponseBody;
import com.evolution.tqi.app.util.UserCreator;
import com.evolution.tqi.app.util.UserRequestBodyCreator;
import com.evolution.tqi.app.util.UserResponseBodyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repositoryMock;

    @BeforeEach
    void setUp(){
        UserModel user = UserCreator.createUser();

        BDDMockito.when(repositoryMock.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        BDDMockito.when(repositoryMock.findByEmail(ArgumentMatchers.any())).thenReturn(List.of());
        BDDMockito.when(repositoryMock.save(ArgumentMatchers.any())).thenReturn(user);
    }

    @Test
    @DisplayName("isValidRequisition returns true when CPF, email and annualRevenue are valid")
    void isValidRequisition_ReturnsTrue_WhenSuccessful(){
        UserModelPostRequestBody request = UserRequestBodyCreator.createUserToBeSaved();

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("isValidRequisition returns false when annualRevenue is not valid")
    void isValidRequisition_ReturnsFalse_WhenAnnualRevenueIsNotValid(){
        UserModelPostRequestBody request = UserRequestBodyCreator.createUserToBeSaved();
        request.setAnnualRevenue(-1L);

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidRequisition returns false when cpf is already used")
    void isValidRequisition_ReturnsFalse_WhenCpfIsAlreadyUsed(){
        UserModel user = UserCreator.createUser();
        BDDMockito.when(repositoryMock.findByCpf(ArgumentMatchers.any())).thenReturn(List.of(user));

        UserModelPostRequestBody request = UserRequestBodyCreator.createUserToBeSaved();
        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidRequisition returns false when email is already used")
    void isValidRequisition_ReturnsFalse_WhenNotSuccessful(){
        UserModel user = UserCreator.createUser();
        BDDMockito.when(repositoryMock.findByEmail(ArgumentMatchers.any())).thenReturn(List.of(user));

        UserModelPostRequestBody request = UserRequestBodyCreator.createUserToBeSaved();
        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("save persists UserModel in DB when successful")
    void save_PersistsUserInDatabase_WhenSuccessful(){
        UserModelPostResponseBody userExpected = UserResponseBodyCreator.createUserSaved();
        UserModelPostRequestBody userToBeSaved = UserRequestBodyCreator.createUserToBeSaved();

        UserModelPostResponseBody result = service.save(userToBeSaved);

        Assertions.assertThat(userExpected).isEqualTo(result);
        Assertions.assertThat(result).isNotNull();
    }
}