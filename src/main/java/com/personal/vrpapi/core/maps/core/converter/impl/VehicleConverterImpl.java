package com.personal.vrpapi.core.maps.core.converter.impl;

import com.personal.vrpapi.core.maps.core.converter.DepotConverter;
import com.personal.vrpapi.core.maps.core.converter.VehicleConverter;
import com.personal.vrpapi.core.maps.core.dto.response.VehicleData;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class VehicleConverterImpl implements VehicleConverter {

    @Resource
    private DepotConverter depotConverter;

    @Override
    public VehicleData convert(Vehicle vehicle) {
        if (Objects.isNull(vehicle)) {
            VehicleData vehicleData = new VehicleData();
            vehicleData.setVehicleId(vehicle.getId());
            vehicleData.setDepotData(depotConverter.convertDepot2Data(vehicle.getDepot()));
            vehicleData.setType(vehicle.getVehicleType());
            vehicleData.setCapacity(vehicle.getCapacity());
            vehicleData.setDriverId(vehicle.getDriver().getId());
            return vehicleData;
        }
        return null;
    }
}
