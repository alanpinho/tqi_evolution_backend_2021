package com.evolution.tqi.app.loan_application.controller;

import com.evolution.tqi.app.loan_application.model.LoanModel;
import com.evolution.tqi.app.loan_application.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService service;

    @PostMapping("/new")
    public ResponseEntity<LoanModel> save(@RequestBody LoanModel requestBody) throws Exception{
        if(service.isValidRequisition(requestBody))
            return new ResponseEntity<>(service.save(requestBody), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
