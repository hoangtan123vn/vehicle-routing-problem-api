package com.personal.vrpapi.core.maps.route.converter.impl;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.maps.core.dto.request.CustomerRequest;
import com.personal.vrpapi.core.maps.core.dto.response.RouteDetailData;
import com.personal.vrpapi.core.maps.route.converter.RouteDetailConverter;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Override
    public RouteDetail buildRouteDetail(CustomerRequest customerRequest, Customer customer) {
        RouteDetail routeDetail = new RouteDetail();
        routeDetail.setCustomer(customer);
        routeDetail.setLat(customerRequest.getLat());
        routeDetail.setLng(customerRequest.getLng());
        routeDetail.setDemand(customerRequest.getDemand());
        routeDetail.setPostalCode(customerRequest.getPostalCode());
        routeDetail.setShippingAddress(customerRequest.getShippingAddress());
        routeDetail.setIsRouted(false);
        routeDetail.setIsShipped(false);
        routeDetail.setStatusRoute(StatusRoute.SHIPPING);
        return routeDetail;
    }

    @Override
    public RouteDetailData convert(RouteDetail routeDetail) {
        return RouteDetailData.builder()
                .id(routeDetail.getId())
                .customerId(routeDetail.getCustomer().getId())
                .isRouted(routeDetail.getIsRouted())
                .sequence(routeDetail.getSequence())
                .driverId(Objects.isNull(routeDetail.getDriver()) ? null : routeDetail.getDriver().getId())
                .isShipped(routeDetail.getIsShipped())
                .status(routeDetail.getStatusRoute())
                .lat(routeDetail.getLat())
                .lng(routeDetail.getLng())
                .address(routeDetail.getAddress())
                .postalCode(routeDetail.getPostalCode())
                .build();
    }

    @Override
    public List<RouteDetailData> convertAll(List<RouteDetail> routeDetails) {
        if (CollectionUtils.isNotEmpty(routeDetails)) {
            return routeDetails.stream().map(this::convert).toList();
        }
        return Collections.emptyList();
    }
}
