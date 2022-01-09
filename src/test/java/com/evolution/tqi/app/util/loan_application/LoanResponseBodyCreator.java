package com.evolution.tqi.app.util.loan_application;

import com.evolution.tqi.app.loan_application.response.LoanResponseBody;

public class LoanResponseBodyCreator {

    public static LoanResponseBody createLoanResponseBody(){
        return LoanResponseBody.builder()
                .totalLoanValueRequired(LoanCreator.createLoan().getTotalLoanValueRequired())
                .dateOfFirstInstalment(LoanCreator.createLoan().getDateOfFirstInstalment())
                .numberOfInstalments(LoanCreator.createLoan().getNumberOfInstalments())
                .user(EmbeddedUserResponseBodyCreator.createEmbeddedUserResponseBody())
                .build();
    }
}
