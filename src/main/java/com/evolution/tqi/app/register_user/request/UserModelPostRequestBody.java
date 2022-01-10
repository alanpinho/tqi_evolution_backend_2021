package com.evolution.tqi.app.register_user.request;

import com.evolution.tqi.app.register_user.model.AddressModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModelPostRequestBody {
    public static final Long MIN_ANNUAL_REVENUE = 1L;

    @NotEmpty(message = "The first name cannot be empty")
    @Size(min = 3, max = 20)
    @Schema(description = "The user's first name", example = "Robert")
    private String firstName;

    @NotEmpty(message = "The last name cannot be empty")
    @Size(min = 3, max = 150)
    @Schema(description = "The user's last name. Can be more than one", example = "C. Martin")
    private String lastName;

    @CPF
    @NotEmpty(message = "The cpf cannot be empty")
    @Schema(description = "The user's CPF (brazilian tax number)", example = "812.023.583-57")
    private String cpf;

    @Schema(description = "The user's RG (brazilian identity card)", example = "25.241.404-4")
    private String rg;

    @Email
    @NotEmpty(message = "The email cannot be empty")
    @Schema(description = "The user's email. Each email can be used in only one account", example = "email@email.com")
    private String email;

    @NotEmpty(message = "The password cannot be empty")
    @Schema(description = "Password you want to set for this account", example = "2aK&gqEb")
    private String password;

    @Schema(description = "The user's address")
    private AddressModel address;

    @NotNull(message = "The annual revenue cannot be null")
    @Schema(description = "The user's annual revenue", example = "5000000")
    private Long annualRevenue;
}
