package com.personal.vrpapi.core.maps.core.factory.impl;

import com.personal.vrpapi.core.base.exception.BaseException;
import com.personal.vrpapi.core.maps.core.converter.RouteConverter;
import com.personal.vrpapi.core.maps.core.enums.LocalSearchType;
import com.personal.vrpapi.core.maps.core.factory.LocalSearchFactory;
import com.personal.vrpapi.core.maps.core.service.SearchService;
import com.personal.vrpapi.core.maps.core.service.VehicleService;
import com.personal.vrpapi.core.maps.core.service.impl.InstraSearchServiceImpl;
import com.personal.vrpapi.core.maps.core.service.impl.InterSearchServiceImpl;
import com.personal.vrpapi.core.maps.route.service.RouteDetailService;
import com.personal.vrpapi.core.maps.route.service.RouteService;
import com.personal.vrpapi.googleapi.service.GoogleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LocalSearchFactoryImpl implements LocalSearchFactory {

    @Resource
    private GoogleService googleService;

    @Resource
    private RouteConverter routeConverter;

    @Resource
    private RouteService routeService;

    @Resource
    private VehicleService vehicleService;

    @Resource
    private RouteDetailService routeDetailService;

    @Override
    public SearchService getInstance(LocalSearchType type) {
        if (LocalSearchType.INSTRA.equals(type)) {
            return new InstraSearchServiceImpl(googleService, routeConverter, routeService, vehicleService, routeDetailService);
        } else if (LocalSearchType.INTER.equals(type)) {
            return new InterSearchServiceImpl(googleService, routeConverter, routeService, vehicleService, routeDetailService);
        } else {
            throw new BaseException("No valid LocalSearchType");
        }
    }
}
