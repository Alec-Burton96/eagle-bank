package com.barclays.eagle.service;

import com.barclays.eagle.mapper.AccountMapper;
import com.barclays.eagle.model.account.entity.Account;
import com.barclays.eagle.model.account.requestDTO.CreateAccountRequest;
import com.barclays.eagle.model.account.responseDTO.CreateAccountSuccessResponse;
import com.barclays.eagle.repository.AccountRepository;
import com.barclays.eagle.security.JwtCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final JwtCache jwtCache;

    public CreateAccountSuccessResponse createAccount(CreateAccountRequest createAccountRequest) {
        String authToken = JwtCache.getAuthTokenForRequest();
        String userId = jwtCache.getJwtCacheEntries()
                .stream()
                .filter(entry -> entry.token().equals(authToken))
                .findFirst()
                .map(JwtCache.JwtCacheEntry::userId)
                .orElseThrow();
        Account account = AccountMapper.createAccountRequestToEntity(createAccountRequest, userId);

        Account createdAccount = accountRepository.save(account);
        return AccountMapper.accountToCreateAccountSuccessResponse(account);
    }
}
