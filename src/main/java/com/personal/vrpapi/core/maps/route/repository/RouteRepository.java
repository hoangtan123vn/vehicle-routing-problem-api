package com.personal.vrpapi.core.maps.route.repository;

import com.personal.vrpapi.core.maps.route.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
