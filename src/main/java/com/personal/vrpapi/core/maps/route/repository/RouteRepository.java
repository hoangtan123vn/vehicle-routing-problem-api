package com.personal.vrpapi.core.maps.route.repository;

import com.personal.vrpapi.core.base.repository.CommonRepository;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.route.entity.Route;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepository extends CommonRepository<Route> {

    Optional<Route> findByVehicleAndMap(Vehicle vehicle, Map map);
}
