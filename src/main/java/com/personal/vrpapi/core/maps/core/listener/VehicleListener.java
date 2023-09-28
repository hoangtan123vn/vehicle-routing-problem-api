package com.personal.vrpapi.core.maps.core.listener;

import com.personal.vrpapi.core.base.utils.BeanUtils;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.entity.VehicleCode;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.transaction.Transactional;
import java.util.Objects;

public class VehicleListener {

    @PrePersist
    @Transactional
    public void onBeforeCreate(Map map) {
        if (Objects.isNull(map.getMapId())) {
            EntityManager entityManager = BeanUtils.getBean(EntityManager.class);
            VehicleCode vehicleCode = new VehicleCode();
            entityManager.persist(vehicleCode);
            map.setMapId(vehicleCode.getId());
            entityManager.remove(vehicleCode);
        }
    }
}
