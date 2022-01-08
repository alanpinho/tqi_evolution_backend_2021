package com.evolution.tqi.app.loan_application.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanResponseBody {

    private EmbeddedUserResponseBody user;

    private Long totalLoanValueRequired;

    private LocalDate dateOfFirstInstalment;

    private Integer numberOfInstalments;
}
