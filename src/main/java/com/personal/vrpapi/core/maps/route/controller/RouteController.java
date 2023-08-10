package com.personal.vrpapi.core.maps.route.controller;

import com.personal.vrpapi.core.maps.route.dto.request.DistanceRequest;
import com.personal.vrpapi.googleapi.converter.DistanceMatrixConverter;
import com.personal.vrpapi.googleapi.dto.response.DistanceMatrixData;
import com.personal.vrpapi.googleapi.service.GoogleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Resource
    private GoogleService googleService;

    @Resource
    private DistanceMatrixConverter converter;

    @GetMapping("/distance")
    DistanceMatrixData getDetailDistance(@RequestBody DistanceRequest request) {
        return converter.convertDistanceMatrix2Data(googleService.getSingleDistance(request.getOrigin(), request.getDestination()));
    }
}
