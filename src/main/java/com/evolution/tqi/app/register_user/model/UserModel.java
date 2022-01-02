package com.evolution.tqi.app.register_user.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CPF
    private String cpf;

    private String rg;

    @Email
    private String email;

    private String firstName;
    private String lastName;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private AddressModel address;

    private Long annualRevenue;
}
