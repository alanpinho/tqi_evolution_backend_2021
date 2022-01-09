package com.evolution.tqi.app.loan_application.controller;

import com.evolution.tqi.app.loan_application.response.LoanResponseBody;
import com.evolution.tqi.app.loan_application.service.LoanService;
import com.evolution.tqi.app.util.loan_application.LoanRequestBodyCreator;
import com.evolution.tqi.app.util.loan_application.LoanResponseBodyCreator;
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
class LoanControllerTest {

    @InjectMocks
    private LoanController controller;

    @Mock
    private LoanService serviceMock;

    @BeforeEach
    void setUp(){
        LoanResponseBody loanSaved = LoanResponseBodyCreator.createLoanResponseBody();

        BDDMockito.when(serviceMock.save(ArgumentMatchers.any())).thenReturn(loanSaved);
        BDDMockito.when(serviceMock.isValidRequisition(ArgumentMatchers.any())).thenReturn(true);
    }

    @Test
    @DisplayName("save persists loan application in the database when successful")
    void save_PersistsLoanApplication_WhenSuccessful(){
        LoanResponseBody expectedLoan = LoanResponseBodyCreator.createLoanResponseBody();

        ResponseEntity<LoanResponseBody> response = controller.save(LoanRequestBodyCreator.createLoanRequestBody());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).isEqualTo(expectedLoan);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @DisplayName("save returns status code 400 when requisition is not valid")
    void save_ReturnsBadRequest_WhenRequisitionIsNotValid(){
        BDDMockito.when(serviceMock.isValidRequisition(ArgumentMatchers.any())).thenReturn(false);

        ResponseEntity<LoanResponseBody> response = controller.save(LoanRequestBodyCreator.createLoanRequestBody());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}