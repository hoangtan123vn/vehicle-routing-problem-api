package com.personal.vrpapi.core.maps.core.service.impl;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.maps.core.entity.Depot;
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
import java.math.BigDecimal;
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

    @Override
    public List<Route> search(List<Vehicle> vehicles, List<RouteDetail> routeDetails, Depot depot, com.personal.vrpapi.core.maps.core.entity.Map map) {

        int notInserted = routeDetails.size();
        int numberOfVehicles = vehicles.size();

        //generate List<Customer> of vehicle ship to
        Map<Vehicle, List<RouteDetail>> customersOfVehicles = generateMapVehicles(vehicles);
        for (Vehicle vehicle : vehicles) {
            Route route = new Route();
            Double capacity = vehicle.getCapacity();
            BigDecimal loading = BigDecimal.ZERO;
            boolean isFinal = false;
            List<RouteDetail> nodeSequences = customersOfVehicles.get(vehicle);


            if (notInserted == 0) {
                isFinal = true;
            }

            while(isFinal == false) {
                int positionOfTheNextOne = -1;
                Double bestCostForTheNextOne = Double.MAX_VALUE;
                for (RouteDetail routeDetail : routeDetails) {
                    if (!routeDetail.getIsRouted() && routeDetail.getDemand() <= capacity) {
                        Double trialCost;
                        if (CollectionUtils.isEmpty(nodeSequences)) {
                            String origin = depot.getAddress();
                            trialCost = googleService.getValueSingleDistance(origin, routeDetail.getShippingAddress());
                        } else {
                            RouteDetail detail = nodeSequences.get(nodeSequences.size() - 1);
                            trialCost = googleService.getValueSingleDistance(detail.getShippingAddress(), routeDetail.getShippingAddress());
                        }

                        if (trialCost < bestCostForTheNextOne) {
                            positionOfTheNextOne = routeDetails.indexOf(routeDetail);
                            bestCostForTheNextOne = trialCost;
                        }
                    }
                }
                RouteDetail routeDetail = buildRouteDetail(route, vehicle.getDriver(), customer, Long.valueOf(routeDetails.size() + 1));
                routeDetails.add(routeDetail);
                route.setRouteDetails(routeDetails);
            }
        }

    }

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

    private Map<Route, List<RouteDetail>> generateRoutesByVehicles(List<Vehicle> vehicles, com.personal.vrpapi.core.maps.core.entity.Map map) {
        Map<Route, List<RouteDetail>> routes = new HashMap<>();
        for (Vehicle vehicle : vehicles) {
            Route route = routeRepository.findByVehicleAndMap(vehicle, map).orElse(new Route());
            routes.put(route, new ArrayList<>());
        }
        return routes;
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
