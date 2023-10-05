package com.personal.vrpapi.core.maps.core.service.impl;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.core.service.SearchService;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
import com.personal.vrpapi.core.maps.route.repository.RouteRepository;
import com.personal.vrpapi.googleapi.converter.DistanceMatrixConverter;
import com.personal.vrpapi.googleapi.service.GoogleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InstraSearchServiceImpl implements SearchService {

    @Resource
    private RouteRepository routeRepository;

    @Resource
    private GoogleService googleService;

    @Resource
    private DistanceMatrixConverter distanceMatrixConverter;

//    @Override
//    public List<Route> search(List<Vehicle> vehicles, List<RouteDetail> routeDetails, Depot depot, com.personal.vrpapi.core.maps.core.entity.Map map) {
//
//    }

    private RouteDetail buildRouteDetail(Route route, Driver driver, Customer customer, Long sequence) {
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

    private Map<Vehicle, List<RouteDetail>> generateMapVehicles(List<Vehicle> vehicles) {
        Map<Vehicle, List<RouteDetail>> map = new HashMap<>();
        if (CollectionUtils.isNotEmpty(vehicles)) {
            for (Vehicle vehicle : vehicles) {
                map.put(vehicle, new ArrayList<>());
            }
        }
        return map;
    }
}
