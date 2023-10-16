package com.personal.vrpapi.core.maps.route.controller;

import com.personal.vrpapi.core.maps.core.converter.RouteConverter;
import com.personal.vrpapi.core.maps.core.dto.response.RouteData;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.enums.LocalSearchType;
import com.personal.vrpapi.core.maps.core.enums.VehicleType;
import com.personal.vrpapi.core.maps.core.factory.LocalSearchFactory;
import com.personal.vrpapi.core.maps.core.service.DepotService;
import com.personal.vrpapi.core.maps.core.service.MapService;
import com.personal.vrpapi.core.maps.core.service.SearchService;
import com.personal.vrpapi.core.maps.route.dto.request.DistanceRequest;
import com.personal.vrpapi.core.maps.route.dto.request.InitSearchRequest;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.service.RouteDetailService;
import com.personal.vrpapi.googleapi.converter.DistanceMatrixConverter;
import com.personal.vrpapi.googleapi.dto.response.DistanceMatrixData;
import com.personal.vrpapi.googleapi.service.GoogleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Resource
    private GoogleService googleService;

    @Resource
    private DistanceMatrixConverter distanceMatrixConverter;

    @Resource
    private RouteConverter routeConverter;

    @Resource
    private LocalSearchFactory localSearchFactory;

    @Resource
    private DepotService depotService;

    @Resource
    private MapService mapService;

    @Resource
    private RouteDetailService routeDetailService;

    @GetMapping("/distance")
    DistanceMatrixData getDetailDistance(@RequestBody DistanceRequest request) {
        return distanceMatrixConverter.convertDistanceMatrix2Data(googleService.getSingleDistance(request.getOrigin(), request.getDestination()));
    }

    @PostMapping("/init")
    List<RouteData> initRoutesOnMap(@RequestBody @Valid InitSearchRequest request) {
        SearchService searchService = localSearchFactory.getInstance(LocalSearchType.INSTRA);
        Depot depot = depotService.findById(request.getDepotId());
        Map map = mapService.getMap(request.getMapId());
        List<RouteDetail> routeDetails = routeDetailService.findAllByIdIn(request.getRouteDetailIds());

        List<Route> routes = searchService.search(routeDetails, depot, map, VehicleType.ALL);
        return routeConverter.convertAll(routes);
    }
}
