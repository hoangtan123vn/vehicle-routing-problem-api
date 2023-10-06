package com.personal.vrpapi.core.maps.core.converter;

import com.personal.vrpapi.core.maps.core.dto.response.VehicleData;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;

public interface VehicleConverter {

    VehicleData convert(Vehicle vehicle);
}
