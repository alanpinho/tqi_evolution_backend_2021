package com.evolution.tqi.app.loan_application.controller;

import com.evolution.tqi.app.loan_application.request.LoanRequestBody;
import com.evolution.tqi.app.loan_application.response.LoanResponseBody;
import com.evolution.tqi.app.loan_application.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Persists a loan application in the database if the requisition is valid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "When requisition is not valid")
    })
    public ResponseEntity<LoanResponseBody> save(@RequestBody LoanRequestBody requestBody){
        if(service.isValidRequisition(requestBody))
            return new ResponseEntity<>(service.save(requestBody), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
