package com.barclays.eagle.controller;

import com.barclays.eagle.model.account.requestDTO.CreateAccountRequest;
import com.barclays.eagle.model.account.responseDTO.CreateAccountSuccessResponse;
import com.barclays.eagle.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/accounts")
@RequiredArgsConstructor
public class AccountController
{
    private final AccountService accountService;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAccountSuccessResponse createAccount(
            @RequestBody
            @Valid
            CreateAccountRequest request) {
        return accountService.createAccount(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CreateAccountSuccessResponse> fetchAccounts() {
        return accountService.fetchAccounts();
    }

}
