package com.barclays.eagle.controller;

import com.barclays.eagle.model.transaction.requestDTO.CreateTransactionRequest;
import com.barclays.eagle.model.transaction.responseDTO.CreateTransactionSuccessResponse;
import com.barclays.eagle.service.TransactionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/accounts/{accountNumber}/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Validated
    public CreateTransactionSuccessResponse createTransaction(
            @PathVariable
            @Pattern(regexp = "^01\\d{6}$", message = "Invalid accountNumber format")
            String accountNumber,
            @RequestBody
            @Valid
            CreateTransactionRequest request) {
        return transactionService.createTransaction(request, accountNumber);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Validated
    public List<CreateTransactionSuccessResponse> fetchTransactions(
            @PathVariable
            @Pattern(regexp = "^01\\d{6}$", message = "Invalid accountNumber format")
            String accountNumber) {
        return transactionService.fetchTransactions(accountNumber);
    }

}
