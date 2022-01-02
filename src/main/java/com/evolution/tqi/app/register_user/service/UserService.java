package com.evolution.tqi.app.register_user.service;

import com.evolution.tqi.app.register_user.model.UserModel;
import com.evolution.tqi.app.register_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<UserModel> findAll(){
        return repository.findAll();
    }

    public UserModel save(UserModel userModel){
        return repository.save(userModel);
    }
}
