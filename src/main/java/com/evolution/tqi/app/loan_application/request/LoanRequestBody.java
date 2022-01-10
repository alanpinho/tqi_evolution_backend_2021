package com.evolution.tqi.app.loan_application.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequestBody {

    public static final Integer MIN_NUMBER_OF_INSTALMENTS = 1;
    public static final Integer MAX_NUMBER_OF_INSTALMENTS = 60;
    public static final Integer MIN_LOAN_VALUE_REQUIRED = 1;
    public static final Integer MIN_DATE_IN_MONTHS = 0;
    public static final Integer MAX_DATE_IN_MONTHS = 3;

    @JoinColumn(name = "user_id")
    @Schema(description = "User's ID who wants to make a loan application", example = "1")
    private EmbeddedUserRequestBody user;

    @Schema(description = "Total value you want to make a loan application", example = "20000")
    private Long totalLoanValueRequired;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Schema(description = "Date of the first payment. The max is 3 months counts from today. The format is dd/MM/yyyy")
    private LocalDate dateOfFirstInstalment;

    @Schema(description = "The number of instalments. The max number of instalments is 60", example = "25")
    private Integer numberOfInstalments;
}
