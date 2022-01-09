package com.evolution.tqi.app.loan_application.service;

import com.evolution.tqi.app.loan_application.model.LoanModel;
import com.evolution.tqi.app.loan_application.repository.LoanRepository;
import com.evolution.tqi.app.loan_application.request.LoanRequestBody;
import com.evolution.tqi.app.loan_application.response.LoanResponseBody;
import com.evolution.tqi.app.mapper.LoanModelMapper;
import com.evolution.tqi.app.register_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository repository;
    private final UserRepository userRepository;

    public boolean isValidRequisition(LoanRequestBody requestBody){
        if(isValidNumberOfInstalments(requestBody.getNumberOfInstalments()) &&
            isValidDate(requestBody.getDateOfFirstInstalment()) &&
            isValidUser(requestBody.getUser().getId()))
            return true;
        return false;
    }

    private boolean isValidNumberOfInstalments(Integer numberOfInstalments){
        if(numberOfInstalments >= LoanRequestBody.MIN_NUMBER_OF_INSTALMENTS &&
                numberOfInstalments <= LoanRequestBody.MAX_NUMBER_OF_INSTALMENTS)
            return true;
        return false;
    }

    private boolean isValidDate(LocalDate dateOfFirstInstalment){
        LocalDate now = LocalDate.now();
        LocalDate maxDate = now.plusMonths(LoanRequestBody.MAX_DATE_IN_MONTHS).plusDays(1);
        LocalDate minDate = now.plusMonths(LoanRequestBody.MIN_DATE_IN_MONTHS).plusDays(1);
        if(dateOfFirstInstalment.isBefore(maxDate) && dateOfFirstInstalment.isAfter(minDate))
            return true;
        return false;
    }

    private boolean isValidUser(Long userId){
        if(userRepository.findById(userId).isPresent())
            return true;
        return false;
    }

    public LoanResponseBody save(LoanRequestBody requestBody){
        LoanModel savedLoan = repository.save(LoanModelMapper.INSTANCE.toLoanModel(requestBody));
        return LoanModelMapper.INSTANCE.toLoanResponseBody(savedLoan);
    }

}
