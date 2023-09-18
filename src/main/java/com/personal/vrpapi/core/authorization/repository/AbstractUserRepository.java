package com.personal.vrpapi.core.authorization.repository;

import com.personal.vrpapi.core.base.entity.AbstractUser;
import com.personal.vrpapi.core.base.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractUserRepository extends CommonRepository<AbstractUser> {

    AbstractUser findByUserName(String username);
}
