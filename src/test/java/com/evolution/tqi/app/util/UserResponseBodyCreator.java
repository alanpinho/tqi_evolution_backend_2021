package com.evolution.tqi.app.util;

import com.evolution.tqi.app.register_user.model.AddressModel;
import com.evolution.tqi.app.register_user.response.UserModelPostResponseBody;

public class UserResponseBodyCreator {

    public static UserModelPostResponseBody createUserSaved(){
        return UserModelPostResponseBody.builder()
                .id(UserCreator.createUser().getId())
                .firstName(UserCreator.createUser().getFirstName())
                .lastName(UserCreator.createUser().getLastName())
                .rg(UserCreator.createUser().getRg())
                .cpf(UserCreator.createUser().getCpf())
                .annualRevenue(UserCreator.createUser().getAnnualRevenue())
                .email(UserCreator.createUser().getEmail())
                .address(AddressModel
                        .builder()
                        .city(UserCreator.createUser().getAddress().getCity())
                        .state(UserCreator.createUser().getAddress().getState())
                        .zipCode(UserCreator.createUser().getAddress().getZipCode())
                        .district(UserCreator.createUser().getAddress().getDistrict())
                        .street(UserCreator.createUser().getAddress().getStreet())
                        .houseNumber(UserCreator.createUser().getAddress().getHouseNumber())
                        .build())
                .build();
    }
}
