package com.evolution.tqi.app.util.loan_application;

import com.evolution.tqi.app.loan_application.model.LoanModel;
import com.evolution.tqi.app.loan_application.request.LoanRequestBody;
import com.evolution.tqi.app.util.UserCreator;

import java.time.LocalDate;

public class LoanCreator {
    public static LoanModel createLoan(){
        return LoanModel.builder()
                .id(1L)
                .totalLoanValueRequired(20000L)
                .dateOfFirstInstalment(LocalDate.now().plusMonths(LoanRequestBody.MAX_DATE_IN_MONTHS))
                .numberOfInstalments(LoanRequestBody.MAX_NUMBER_OF_INSTALMENTS)
                .user(UserCreator.createUser())
                .build();
    }
}
