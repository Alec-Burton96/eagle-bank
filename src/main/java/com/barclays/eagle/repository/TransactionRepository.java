package com.barclays.eagle.repository;

import com.barclays.eagle.model.transaction.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> getTransactionsByAccountNumber(String accountNumber);

    List<Transaction> getTransactionsByAccountNumberAndUserId(String accountNumber, String userId);
}
