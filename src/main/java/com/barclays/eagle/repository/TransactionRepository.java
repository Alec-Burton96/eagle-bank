package com.barclays.eagle.repository;

import com.barclays.eagle.model.transaction.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
