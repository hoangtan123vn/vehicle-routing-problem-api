package com.personal.vrpapi.core.authorization.repository;

import com.personal.vrpapi.core.authorization.entity.Role;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(RoleEnum roleEnum);
}
