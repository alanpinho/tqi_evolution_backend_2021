package com.evolution.tqi.app.util.loan_application;

import com.evolution.tqi.app.loan_application.request.LoanRequestBody;

public class LoanRequestBodyCreator {
    public static LoanRequestBody createLoanRequestBody(){
        return LoanRequestBody.builder()
                .totalLoanValueRequired(LoanCreator.createLoan().getTotalLoanValueRequired())
                .dateOfFirstInstalment(LoanCreator.createLoan().getDateOfFirstInstalment())
                .numberOfInstalments(LoanCreator.createLoan().getNumberOfInstalments())
                .user(EmbeddedUserRequestBodyCreator.createEmbeddedUserRequestBody())
                .build();
    }
}
