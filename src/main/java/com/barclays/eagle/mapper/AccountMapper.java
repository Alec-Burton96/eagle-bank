package com.barclays.eagle.mapper;

import com.barclays.eagle.model.account.entity.Account;
import com.barclays.eagle.model.account.requestDTO.CreateAccountRequest;
import com.barclays.eagle.model.account.responseDTO.CreateAccountSuccessResponse;

public class AccountMapper {

    public static Account createAccountRequestToEntity(CreateAccountRequest request, String userId) {
        return new Account(request.name(),
                request.accountType(),
                "10-10-10",
                0.00,
                "GBP",
                userId);
    }

    public static CreateAccountSuccessResponse accountToCreateAccountSuccessResponse(Account account) {
        return new CreateAccountSuccessResponse(account.getAccountNumber(),
                account.getSortCode(),
                account.getName(),
                account.getAccountType(),
                account.getBalance(),
                account.getCurrency(),
                account.getCreatedTimestamp(),
                account.getUpdatedTimestamp());
    }
}
