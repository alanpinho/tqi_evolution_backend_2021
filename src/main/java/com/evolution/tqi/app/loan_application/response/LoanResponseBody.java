package com.evolution.tqi.app.loan_application.response;

import com.evolution.tqi.app.register_user.model.UserModel;
import com.evolution.tqi.app.register_user.request.UserModelPostRequestBody;
import com.evolution.tqi.app.register_user.response.UserModelPostResponseBody;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanResponseBody {

    private EmbeddedUserResponseBody user;

    private Long totalLoanValueRequired;

    private LocalDate dateOfFirstInstalment;

    private Integer numberOfInstalments;
}
