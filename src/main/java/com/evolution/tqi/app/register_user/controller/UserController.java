package com.evolution.tqi.app.register_user.controller;

import com.evolution.tqi.app.register_user.model.UserModel;
import com.evolution.tqi.app.register_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/new")
    public ResponseEntity<UserModel> save(@RequestBody @Valid UserModel userModel){
        if(service.isValidRequisition(userModel))
            return new ResponseEntity(service.save(userModel), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
