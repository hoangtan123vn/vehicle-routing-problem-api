package com.personal.vrpapi.core.maps.core.service.impl;

import com.personal.vrpapi.core.maps.core.converter.RouteConverter;
import com.personal.vrpapi.core.maps.core.service.SearchService;
import com.personal.vrpapi.core.maps.core.service.VehicleService;
import com.personal.vrpapi.core.maps.route.service.RouteDetailService;
import com.personal.vrpapi.core.maps.route.service.RouteService;
import com.personal.vrpapi.googleapi.service.GoogleService;
import org.springframework.stereotype.Component;

@Component
public class InterSearchServiceImpl extends InstraSearchServiceImpl implements SearchService {
    public InterSearchServiceImpl(GoogleService googleService, RouteConverter routeConverter, RouteService routeService, VehicleService vehicleService, RouteDetailService routeDetailService) {
        super(googleService, routeConverter, routeService, vehicleService, routeDetailService);
    }

}
