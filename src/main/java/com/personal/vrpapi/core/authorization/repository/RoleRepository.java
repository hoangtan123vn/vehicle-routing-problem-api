package com.personal.vrpapi.core.authorization.repository;

import com.personal.vrpapi.core.authorization.entity.Role;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.base.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CommonRepository<Role> {

    Role findByRoleName(RoleEnum roleEnum);
}
