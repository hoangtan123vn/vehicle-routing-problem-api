package com.personal.vrpapi.core.maps.route.service.impl;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
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
    public RouteDetail createDefaultRouteDetail(Map map, Customer customer, String shippingAddress, Long sequence, Double demand,
                                                Double lat, Double lng, String postalCode) {
        RouteDetail routeDetail = new RouteDetail();
        routeDetail.setCustomer(customer);
        routeDetail.setShippingAddress(shippingAddress);
        routeDetail.setSequence(sequence);
        routeDetail.setDemand(demand);
        routeDetail.setIsRouted(false);
        routeDetail.setStatusRoute(StatusRoute.READY);
        routeDetail.setLat(lat);
        routeDetail.setLng(lng);
        routeDetail.setPostalCode(postalCode);
        return save(routeDetail);
    }

    @Override
    public RouteDetail save(RouteDetail routeDetail) {
        return routeDetailRepository.save(routeDetail);
    }
}
