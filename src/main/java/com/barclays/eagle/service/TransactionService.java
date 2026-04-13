package com.barclays.eagle.service;

import com.barclays.eagle.mapper.TransactionMapper;
import com.barclays.eagle.model.transaction.entity.Transaction;
import com.barclays.eagle.model.transaction.requestDTO.CreateTransactionRequest;
import com.barclays.eagle.model.transaction.responseDTO.CreateTransactionSuccessResponse;
import com.barclays.eagle.repository.TransactionRepository;
import com.barclays.eagle.security.JwtCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final JwtCache jwtCache;

    public CreateTransactionSuccessResponse createTransaction(CreateTransactionRequest request, String accountNumber) {
        String userId = lookupUserId();
        Transaction transaction = TransactionMapper.createTransactionRequestToEntity(request, userId, accountNumber);

        Transaction createTransaction = transactionRepository.save(transaction);

        return TransactionMapper.transactionToCreateTransactionSuccessResponse(createTransaction);
    }

    private String lookupUserId() {
        String authToken = JwtCache.getAuthTokenForRequest();
        return jwtCache.getJwtCacheEntries()
                .stream()
                .filter(entry -> entry.token().equals(authToken))
                .findFirst()
                .map(JwtCache.JwtCacheEntry::userId)
                .orElseThrow();
    }
}


