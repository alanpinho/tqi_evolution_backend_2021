package com.evolution.tqi.app.register_user.model;

import com.evolution.tqi.app.loan_application.model.LoanModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String rg;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<LoanModel> loanApplications = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private AddressModel address;

    private Long annualRevenue;
}
