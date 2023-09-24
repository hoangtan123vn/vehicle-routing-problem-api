package com.personal.vrpapi.core.maps.core.listener;

import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.entity.MapCode;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PrePersist;
import javax.transaction.Transactional;
import java.util.Objects;

public class MapListener {

    private final EntityManager entityManager;

    @PrePersist
    @Transactional
    public void onBeforeCreate(Map map) {
        if (Objects.isNull(map.getMapId())) {
            entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
            MapCode mapCode = new MapCode();
            entityManager.persist(mapCode);
            map.setMapId(mapCode.getId());
            entityManager.remove(mapCode);
        }
    }
}
