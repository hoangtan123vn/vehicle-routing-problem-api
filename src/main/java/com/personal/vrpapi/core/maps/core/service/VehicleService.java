package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.maps.core.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    /**
     * find List<Vehicle> by List<Ids>
     * @param ids
     * @return
     */
    List<Vehicle> findAllByIdIn(List<Long> ids);
}
