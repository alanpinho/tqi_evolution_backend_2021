package com.evolution.tqi.app.register_user.service;

import com.evolution.tqi.app.mapper.UserModelMapper;
import com.evolution.tqi.app.register_user.model.UserModel;
import com.evolution.tqi.app.register_user.repository.UserRepository;
import com.evolution.tqi.app.register_user.request.UserModelPostRequestBody;
import com.evolution.tqi.app.register_user.response.UserModelPostResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public boolean isValidRequisition(UserModelPostRequestBody userModel){
        if(isValidAnnualRevenue(userModel.getAnnualRevenue()) &&
            cpfDoesNotExistInDatabase(userModel.getCpf()) &&
            emailDoesNotExistInDatabase(userModel.getEmail()))
            return true;
        return false;
    }

    private boolean isValidAnnualRevenue(Long annualRevenue){
        if(annualRevenue >= UserModelPostRequestBody.MIN_ANNUAL_REVENUE)
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

    public UserModelPostResponseBody save(UserModelPostRequestBody userModel){
        UserModel savedUser = repository.save(UserModelMapper.INSTANCE.toUserModel(userModel));
        return UserModelMapper.INSTANCE.toUserModelPostResponseBody(savedUser);
    }
}
