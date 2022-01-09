package com.evolution.tqi.app.loan_application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponseBody {

    private EmbeddedUserResponseBody user;

    private Long totalLoanValueRequired;

    private LocalDate dateOfFirstInstalment;

    private Integer numberOfInstalments;
}
