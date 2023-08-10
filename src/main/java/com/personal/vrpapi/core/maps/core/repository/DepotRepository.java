package com.personal.vrpapi.core.maps.core.repository;

import com.personal.vrpapi.core.maps.core.entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotRepository extends JpaRepository<Depot, Long> {
}
