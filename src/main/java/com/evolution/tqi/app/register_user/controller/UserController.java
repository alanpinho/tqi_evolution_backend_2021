package com.evolution.tqi.app.register_user.controller;

import com.evolution.tqi.app.register_user.model.UserModel;
import com.evolution.tqi.app.register_user.repository.UserRepository;
import com.evolution.tqi.app.register_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> listAll(){
        List<UserModel> allUsers = service.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<UserModel> save(@RequestBody UserModel userModel){
        Optional<UserModel> savedUser = Optional.ofNullable(service.save(userModel));
        return new ResponseEntity(savedUser, HttpStatus.CREATED);
    }
}
