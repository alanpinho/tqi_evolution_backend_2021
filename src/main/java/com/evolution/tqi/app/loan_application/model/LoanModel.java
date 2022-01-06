package com.evolution.tqi.app.loan_application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class LoanModel{

    public static final Integer MIN_NUMBER_OF_INSTALMENTS = 1;
    public static final Integer MAX_NUMBER_OF_INSTALMENTS = 60;
    public static final Integer MIN_DATE_IN_MONTHS = 0;
    public static final Integer MAX_DATE_IN_MONTHS = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totalLoanValueRequired;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfFirstInstalment;

    private Integer numberOfInstalments;

}
