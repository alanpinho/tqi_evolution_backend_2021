package com.evolution.tqi.app.loan_application.request;

import com.evolution.tqi.app.register_user.response.UserModelPostResponseBody;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    public static final Integer MIN_DATE_IN_MONTHS = 0;
    public static final Integer MAX_DATE_IN_MONTHS = 3;

    @JoinColumn(name = "user_id")
    private UserModelPostResponseBody user;

    private Long totalLoanValueRequired;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfFirstInstalment;

    private Integer numberOfInstalments;
}
