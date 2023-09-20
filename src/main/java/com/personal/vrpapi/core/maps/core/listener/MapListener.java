package com.personal.vrpapi.core.maps.core.listener;

import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.entity.MapCode;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PrePersist;
import java.util.Objects;

public class MapListener {

    @PersistenceContext
    private EntityManager entityManager;

    @PrePersist
    public void onBeforeCreate(Map map) {
        if (Objects.isNull(map.getMapId())) {
            MapCode mapCode = new MapCode();
            entityManager.persist(mapCode);
            map.setMapId(mapCode.getId());
            entityManager.remove(mapCode);
        }
    }
}
