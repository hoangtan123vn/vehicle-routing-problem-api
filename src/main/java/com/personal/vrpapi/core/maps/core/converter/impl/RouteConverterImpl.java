package com.personal.vrpapi.core.maps.core.converter.impl;

import com.personal.vrpapi.core.base.entity.AbstractNode;
import com.personal.vrpapi.core.maps.core.converter.RouteConverter;
import com.personal.vrpapi.core.maps.core.dto.response.RouteData;
import com.personal.vrpapi.core.maps.core.dto.response.RouteDetailData;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteConverterImpl implements RouteConverter {

    @Override
    public RouteData convert(Route route) {
        return RouteData.builder()
                .costRoute(route.getCostRoute())
                .loadingRoute(route.getLoadingRoute())
                .dateCompleted(route.getDateCompleted())
                .status(route.getStatusRoute())
                .routeDetails(CollectionUtils.isNotEmpty(route.getRouteDetails()) ?
                        route.getRouteDetails().stream()
                        .map(this::convert)
                        .toList()
                        : null)
                .build();
    }

    @Override
    public RouteDetailData convert(RouteDetail route) {
        return RouteDetailData.builder()
                .customerId(route.getCustomer().getId())
                .isRouted(route.getIsRouted())
                .isShipped(route.getIsShipped())
                .driverId(route.getDriver().getId())
                .dateCompleted(route.getDateCompleted())
                .sequence(route.getSequence())
                .status(route.getStatusRoute())
                .build();
    }

    @Override
    public Route buildRoute(Double costRoute, Double loadingRoute, List<AbstractNode> nodes,
                            Map map, Vehicle vehicle) {
        Route route = new Route();
        route.setLoadingRoute(loadingRoute);
        route.setCostRoute(costRoute);
        route.setMap(map);
        route.setVehicle(vehicle);
        route.setStatusRoute(StatusRoute.READY);
        if (CollectionUtils.isNotEmpty(nodes)) {
            List<RouteDetail> routeDetails = nodes.stream()
                    .filter(RouteDetail.class::isInstance)
                    .map(RouteDetail.class::cast)
                    .toList();

            route.setRouteDetails(routeDetails);
        }
        return route;
    }

    @Override
    public List<RouteData> convertAll(List<Route> routes) {
        return routes.stream().map(this::convert).toList();
    }
}
