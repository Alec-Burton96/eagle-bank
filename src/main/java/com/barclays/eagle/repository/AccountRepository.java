package com.barclays.eagle.repository;

import com.barclays.eagle.model.account.entity.Account;
import com.barclays.eagle.model.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    boolean getAccountByIdGreaterThan(Long idIsGreaterThan);
}
