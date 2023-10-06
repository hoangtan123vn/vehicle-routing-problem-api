package com.personal.vrpapi.core.maps.route.converter;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;

public interface RouteDetailConverter {

    RouteDetail buildRouteDetail(Route route, Driver driver, Customer customer, Long sequence);
}
