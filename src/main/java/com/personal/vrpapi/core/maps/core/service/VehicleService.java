package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.maps.core.dto.request.RegisterVehicleRequest;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.core.enums.VehicleType;

import java.util.List;

public interface VehicleService {

    /**
     * find List<Vehicle> by List<Ids>
     * @param ids
     * @return
     */
    List<Vehicle> findAllByIdIn(List<Long> ids);

    /**
     *
     * @param depot
     * @return
     */
    List<Vehicle> findAllByDepotAndFreeWithType(Depot depot, VehicleType type);

    /**
     *
     * @param driverId
     * @param registerVehicleRequest
     * @return
     */
    Vehicle registerVehicle(Long driverId, RegisterVehicleRequest registerVehicleRequest);

    /**
     *
     * @param driverId
     * @return
     */
    Vehicle getVehicle(Long driverId);
}
