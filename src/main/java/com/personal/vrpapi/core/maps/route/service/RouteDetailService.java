package com.personal.vrpapi.core.maps.route.service;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;

import java.util.List;

public interface RouteDetailService {

    List<RouteDetail> findAllByIdIn(List<Long> ids);

    RouteDetail createDefaultRouteDetail(Map map, Customer customer, String shippingAddress, Long sequence, Double demand,
                                         Double lat, Double lng, String postalCode);

    RouteDetail save(RouteDetail routeDetail);
}
