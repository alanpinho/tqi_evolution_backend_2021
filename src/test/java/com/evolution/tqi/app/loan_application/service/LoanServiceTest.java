package com.evolution.tqi.app.loan_application.service;

import com.evolution.tqi.app.loan_application.model.LoanModel;
import com.evolution.tqi.app.loan_application.repository.LoanRepository;
import com.evolution.tqi.app.loan_application.request.LoanRequestBody;
import com.evolution.tqi.app.loan_application.response.LoanResponseBody;
import com.evolution.tqi.app.register_user.model.UserModel;
import com.evolution.tqi.app.register_user.repository.UserRepository;
import com.evolution.tqi.app.util.UserCreator;
import com.evolution.tqi.app.util.loan_application.LoanCreator;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class LoanServiceTest {
    @InjectMocks
    private LoanService service;

    @Mock
    private LoanRepository repository;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        UserModel validUser = UserCreator.createUser();
        LoanModel loanModel = LoanCreator.createLoan();

        BDDMockito.when(userRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(validUser));
        BDDMockito.when(repository.save(ArgumentMatchers.any())).thenReturn(loanModel);
    }

    @Test
    @DisplayName("isValidRequisition returns true when number of instalments, date and user are valid")
    void isValidRequisition_ReturnsTrue_WhenSuccessful(){
        LoanRequestBody request = LoanRequestBodyCreator.createLoanRequestBody();

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("isValidRequisition returns false when loan value required is zero")
    void isValidRequisition_ReturnsFalse_WhenTotalLoanValueRequiredIsZero(){
        LoanRequestBody request = LoanRequestBodyCreator.createLoanRequestBody();
        request.setTotalLoanValueRequired(0L);

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidRequisition returns false when loan value required is negative")
    void isValidRequisition_ReturnsFalse_WhenTotalLoanValueRequiredIsNegative(){
        LoanRequestBody request = LoanRequestBodyCreator.createLoanRequestBody();
        request.setTotalLoanValueRequired(-1L);

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidRequisition returns false when number of instalments is not valid")
    void isValidRequisition_ReturnsFalse_WhenNumberOfInstalmentsIsNegative(){
        LoanRequestBody request = LoanRequestBodyCreator.createLoanRequestBody();
        request.setNumberOfInstalments(-1);

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidRequisition returns false when number of instalments is not valid")
    void isValidRequisition_ReturnsFalse_WhenNumberOfInstalmentsIsLongerThanLimit(){
        LoanRequestBody request = LoanRequestBodyCreator.createLoanRequestBody();
        request.setNumberOfInstalments(LoanCreator.createLoan().getNumberOfInstalments() + 1);

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidRequisition returns false when date of first instalment is not valid")
    void isValidRequisition_ReturnsFalse_WhenDateIsNotValid(){
        LoanRequestBody request = LoanRequestBodyCreator.createLoanRequestBody();
        request.setDateOfFirstInstalment(LoanCreator.createLoan().getDateOfFirstInstalment().plusDays(1));

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isValidRequisition returns true when User exists in database")
    void isValidRequisition_ReturnsTrue_WhenUserExistsInDatabase(){
        LoanRequestBody request = LoanRequestBodyCreator.createLoanRequestBody();

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("isValidRequisition returns false when User does not exist in database")
    void isValidRequisition_ReturnsFalse_WhenUserDoesNotExistInDatabase(){
        BDDMockito.when(userRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());

        LoanRequestBody request = LoanRequestBodyCreator.createLoanRequestBody();

        Boolean result = service.isValidRequisition(request);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isFalse();
    }

    @Test
    @DisplayName("save persists Loan requisition in database when successful")
    void save_PersistsLoanRequisitionInDatabase_WhenSuccessful(){
        LoanResponseBody loanExpected = LoanResponseBodyCreator.createLoanResponseBody();
        LoanRequestBody loanToBeSaved = LoanRequestBodyCreator.createLoanRequestBody();

        LoanResponseBody result = service.save(loanToBeSaved);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(loanExpected);
    }
}