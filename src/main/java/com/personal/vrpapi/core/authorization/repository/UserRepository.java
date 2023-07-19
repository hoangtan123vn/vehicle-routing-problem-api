package com.personal.vrpapi.core.authorization.repository;

import com.personal.vrpapi.core.authorization.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
