package com.evolution.tqi.app.register_user.response;

import com.evolution.tqi.app.register_user.model.AddressModel;
import lombok.Data;

@Data
public class UserModelPostResponseBody {

    private Long id;

    private String cpf;

    private String rg;

    private String email;

    private String firstName;

    private String lastName;

    private AddressModel address;

    private Long annualRevenue;
}
