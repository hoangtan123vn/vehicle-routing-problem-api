package com.personal.vrpapi.core.maps.route.converter;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.maps.core.dto.request.CustomerRequest;
import com.personal.vrpapi.core.maps.core.dto.response.RouteDetailData;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;

import java.util.List;

public interface RouteDetailConverter {

    RouteDetail buildRouteDetail(Route route, Driver driver, Customer customer, Long sequence);

    RouteDetail buildRouteDetail(CustomerRequest customerRequest, Customer customer);

    RouteDetailData convert(RouteDetail routeDetail);

    List<RouteDetailData> convertAll(List<RouteDetail> routeDetails);
}
