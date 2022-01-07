package com.evolution.tqi.app.register_user.service;

import com.evolution.tqi.app.register_user.model.UserModel;
import com.evolution.tqi.app.register_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public boolean isValidRequisition(UserModel userModel){
        if(isValidAnnualRevenue(userModel.getAnnualRevenue()) &&
            cpfDoesNotExistInDatabase(userModel.getCpf()) &&
            emailDoesNotExistInDatabase(userModel.getEmail()))
            return true;
        return false;
    }

    private boolean isValidAnnualRevenue(Long annualRevenue){
        if(annualRevenue >= UserModel.MIN_ANNUAL_REVENUE)
            return true;
        return false;
    }

    private boolean cpfDoesNotExistInDatabase(String cpf){
        if(repository.findByCpf(cpf).isEmpty())
            return true;
        return false;
    }

    private boolean emailDoesNotExistInDatabase(String email){
        if(repository.findByEmail(email).isEmpty())
            return true;
        return false;
    }

    public UserModel save(UserModel userModel){
        return repository.save(userModel);
    }
}
