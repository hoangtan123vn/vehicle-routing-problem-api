package com.personal.vrpapi.core.maps.core.listener;

import com.personal.vrpapi.core.base.utils.BeanUtils;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.core.entity.VehicleCode;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import java.util.Objects;

public class VehicleListener {

    @PrePersist
    public void onBeforeCreate(Vehicle vehicle) {
        if (Objects.isNull(vehicle.getVehicleId())) {
            EntityManager entityManager = BeanUtils.getBean(EntityManager.class);
            VehicleCode vehicleCode = new VehicleCode();
            entityManager.persist(vehicleCode);
            vehicle.setVehicleId(vehicleCode.getId());
            entityManager.remove(vehicleCode);
        }
    }
}
