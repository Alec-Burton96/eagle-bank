package com.barclays.eagle.repository;

import com.barclays.eagle.model.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
