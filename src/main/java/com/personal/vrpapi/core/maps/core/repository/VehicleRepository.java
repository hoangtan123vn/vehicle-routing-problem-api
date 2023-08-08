package com.personal.vrpapi.core.maps.core.repository;

import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
