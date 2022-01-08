package com.evolution.tqi.app.register_user.request;

import com.evolution.tqi.app.register_user.model.AddressModel;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModelPostRequestBody {
    public static final Long MIN_ANNUAL_REVENUE = 1L;

    @CPF
    @NotEmpty(message = "The cpf cannot be empty")
    private String cpf;

    private String rg;

    @Email
    @NotEmpty(message = "The email cannot be empty")
    private String email;

    @NotEmpty(message = "The password cannot be empty")
    private String password;

    @NotEmpty(message = "The first name cannot be empty")
    @Size(min = 3, max = 20)
    private String firstName;

    @NotEmpty(message = "The last name cannot be empty")
    @Size(min = 3, max = 150)
    private String lastName;

    private AddressModel address;

    @NotNull(message = "The annual revenue cannot be null")
    private Long annualRevenue;
}
