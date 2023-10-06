package com.personal.vrpapi.core.maps.route.service.impl;

import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.repository.RouteRepository;
import com.personal.vrpapi.core.maps.route.service.RouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteRepository routeRepository;

    @Override
    public Route save(Route route) {
        return routeRepository.save(route);
    }
}
