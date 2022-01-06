package com.evolution.tqi.app.loan_application.service;

import com.evolution.tqi.app.loan_application.model.LoanModel;
import com.evolution.tqi.app.loan_application.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository repository;

    public boolean isValidRequisition(LoanModel requestBody){
        if(isValidNumberOfInstalments(requestBody.getNumberOfInstalments()) &&
            isValidDate(requestBody.getDateOfFirstInstalment()))
            return true;
        return false;
    }

    private boolean isValidNumberOfInstalments(Integer numberOfInstalments){
        if(numberOfInstalments >= LoanModel.MIN_NUMBER_OF_INSTALMENTS &&
                numberOfInstalments <= LoanModel.MAX_NUMBER_OF_INSTALMENTS)
            return true;
        return false;
    }

    private boolean isValidDate(LocalDate dateOfFirstInstalment){
        LocalDate now = LocalDate.now();
        LocalDate maxDate = now.plusMonths(LoanModel.MAX_DATE_IN_MONTHS);
        LocalDate minDate = now.plusMonths(0);
        if(dateOfFirstInstalment.isBefore(maxDate) && dateOfFirstInstalment.isAfter(minDate))
            return true;
        return false;
    }

    public LoanModel save(LoanModel requestBody){
            return repository.save(requestBody);
    }

}
