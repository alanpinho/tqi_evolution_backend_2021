package com.evolution.tqi.app.register_user.model;

import com.evolution.tqi.app.loan_application.model.LoanModel;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user")
    private List<LoanModel> loanApplications = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private AddressModel address;

    private Long annualRevenue;
}
