package com.barclays.eagle.mapper;

import com.barclays.eagle.model.transaction.entity.Transaction;
import com.barclays.eagle.model.transaction.requestDTO.CreateTransactionRequest;
import com.barclays.eagle.model.transaction.responseDTO.CreateTransactionSuccessResponse;

public class TransactionMapper {

    public static Transaction createTransactionRequestToEntity(CreateTransactionRequest request,
                                                               String userId,
                                                               String accountNumber) {
        return new Transaction(
                request.amount(),
                request.currency(),
                request.type(),
                request.reference(),
                userId,
                accountNumber);
    }

    public static CreateTransactionSuccessResponse transactionToCreateTransactionSuccessResponse(Transaction transaction) {
        return new CreateTransactionSuccessResponse(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getType(),
                transaction.getReference(),
                transaction.getUserId(),
                transaction.getCreatedTimestamp());
    }
}
