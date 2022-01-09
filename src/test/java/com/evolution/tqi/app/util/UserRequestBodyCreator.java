package com.evolution.tqi.app.util;

import com.evolution.tqi.app.register_user.model.AddressModel;
import com.evolution.tqi.app.register_user.request.UserModelPostRequestBody;

public class UserRequestBodyCreator {

    public static UserModelPostRequestBody createUserToBeSaved(){
        return UserModelPostRequestBody.builder()
                .firstName(UserCreator.createUser().getFirstName())
                .lastName(UserCreator.createUser().getLastName())
                .rg(UserCreator.createUser().getRg())
                .cpf(UserCreator.createUser().getCpf())
                .annualRevenue(UserCreator.createUser().getAnnualRevenue())
                .email(UserCreator.createUser().getEmail())
                .password(UserCreator.createUser().getPassword())
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

    public static UserModelPostRequestBody createUserWithWrongCpf(){
        return UserModelPostRequestBody.builder()
                .firstName(UserCreator.createUser().getFirstName())
                .lastName(UserCreator.createUser().getLastName())
                .rg(UserCreator.createUser().getRg())
                .cpf(null)
                .annualRevenue(UserCreator.createUser().getAnnualRevenue())
                .email(UserCreator.createUser().getEmail())
                .password(UserCreator.createUser().getPassword())
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
