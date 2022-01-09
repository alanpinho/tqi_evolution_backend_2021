package com.evolution.tqi.app.util;

import com.evolution.tqi.app.register_user.model.AddressModel;
import com.evolution.tqi.app.register_user.model.UserModel;

public class UserCreator {

    public static UserModel createUser(){
        return UserModel.builder()
                .id(1L)
                .firstName("Alan")
                .lastName("Pinho")
                .rg("30.335.637-6")
                .cpf("156.140.143-90")
                .annualRevenue(20000L)
                .email("emailexample@gmail.com")
                .password("123456")
                .address(AddressModel
                        .builder()
                        .city("Uberlândia")
                        .state("Minas Gerais")
                        .zipCode("38405-142")
                        .district("Tibery")
                        .street("Av. Rondon Pacheco")
                        .houseNumber("4600")
                        .build())
                .build();
    }
}
