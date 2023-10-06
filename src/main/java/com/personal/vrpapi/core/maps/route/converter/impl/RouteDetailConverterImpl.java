package com.personal.vrpapi.core.maps.route.converter.impl;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.maps.route.converter.RouteDetailConverter;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
import org.springframework.stereotype.Component;

@Component
public class RouteDetailConverterImpl implements RouteDetailConverter {

    public RouteDetail buildRouteDetail(Route route, Driver driver, Customer customer, Long sequence) {
        RouteDetail routeDetail = new RouteDetail();
        routeDetail.setDriver(driver);
        routeDetail.setRoute(route);
        routeDetail.setCustomer(customer);
        routeDetail.setSequence(sequence);
        routeDetail.setStatusRoute(StatusRoute.SHIPPING);
        routeDetail.setIsShipped(false);
        routeDetail.setIsRouted(true);
        return routeDetail;
    }
}
