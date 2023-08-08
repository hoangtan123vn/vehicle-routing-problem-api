package com.personal.vrpapi.core.authorization.repository;

import com.personal.vrpapi.core.base.entity.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractUserRepository extends JpaRepository<AbstractUser, Long> {

    AbstractUser findByUserName(String username);
}
