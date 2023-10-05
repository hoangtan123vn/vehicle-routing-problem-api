package com.personal.vrpapi.core.maps.route.service.impl;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.repository.RouteDetailRepository;
import com.personal.vrpapi.core.maps.route.service.RouteDetailService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Component
public class RouteDetailServiceImpl implements RouteDetailService {

    @Resource
    private RouteDetailRepository routeDetailRepository;
    @Override
    public List<RouteDetail> findAllByIdIn(List<Long> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            return routeDetailRepository.findAllByIdIn(ids);
        }
        return Collections.emptyList();
    }

    @Override
    public RouteDetail addRouteDetail(Map map, Customer customer, Driver driver) {
        return null;
    }
}
