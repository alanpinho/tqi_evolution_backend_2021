package com.evolution.tqi.app.register_user.controller;

import com.evolution.tqi.app.register_user.request.UserModelPostRequestBody;
import com.evolution.tqi.app.register_user.response.UserModelPostResponseBody;
import com.evolution.tqi.app.register_user.service.UserService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController controller;

    @Mock
    private UserService serviceMock;

    @BeforeEach
    void setUp(){
        UserModelPostResponseBody userSaved = UserResponseBodyCreator.createUserSaved();
        BDDMockito.when(serviceMock.isValidRequisition(ArgumentMatchers.any())).thenReturn(true);
        BDDMockito.when(serviceMock.save(ArgumentMatchers.any(UserModelPostRequestBody.class))).thenReturn(userSaved);
    }

    @Test
    @DisplayName("save persists User when successful")
    void save_PersistsUser_WhenSuccessful(){
        UserModelPostRequestBody userToBeSaved = UserRequestBodyCreator.createUserToBeSaved();
        UserModelPostResponseBody expectedUser = UserResponseBodyCreator.createUserSaved();

        ResponseEntity<UserModelPostResponseBody> response = controller.save(userToBeSaved);

        Assertions.assertThat(expectedUser).isEqualTo(response.getBody()).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @DisplayName("save returns status code 400 when requisition is not valid")
    void save_ReturnsBadRequest_WhenRequisitionIsNotValid(){
        BDDMockito.when(serviceMock.isValidRequisition(ArgumentMatchers.any())).thenReturn(false);

        UserModelPostRequestBody userToBeSaved = UserRequestBodyCreator.createUserWithWrongCpf();

        ResponseEntity<UserModelPostResponseBody> response = controller.save(userToBeSaved);

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}