package com.personal.vrpapi.core.maps.core.listener;

import com.personal.vrpapi.core.base.utils.BeanUtils;
import com.personal.vrpapi.core.maps.core.entity.RouteDetailUUID;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.transaction.Transactional;
import java.util.Objects;

public class RouteDetailListener {
    @PrePersist
    @Transactional
    public void onBeforeCreate(RouteDetail routeDetail) {
        if (Objects.isNull(routeDetail.getRouteDetailUUID())) {
            EntityManager entityManager = BeanUtils.getBean(EntityManager.class);
            RouteDetailUUID routeDetailUUID = new RouteDetailUUID();
            entityManager.persist(routeDetailUUID);
            routeDetail.setRouteDetailUUID(routeDetailUUID.getId());
            entityManager.remove(routeDetailUUID);
        }
    }
}
