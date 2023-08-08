package com.personal.vrpapi.core.maps.core.repository;

import com.personal.vrpapi.core.authorization.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
