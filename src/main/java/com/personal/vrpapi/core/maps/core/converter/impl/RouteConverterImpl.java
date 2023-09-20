package com.personal.vrpapi.core.maps.core.converter.impl;

import com.personal.vrpapi.core.maps.core.converter.RouteConverter;
import com.personal.vrpapi.core.maps.core.dto.response.RouteData;
import com.personal.vrpapi.core.maps.core.dto.response.RouteDetailData;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

@Component
public class RouteConverterImpl implements RouteConverter {

    @Override
    public RouteData convert(Route route) {
        return RouteData.builder()
                .capacityRoute(route.getCapacityRoute())
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
}
