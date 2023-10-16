package com.personal.vrpapi.core.maps.route.controller;

import com.personal.vrpapi.core.maps.core.dto.request.CustomerRequest;
import com.personal.vrpapi.core.maps.core.dto.response.RouteDetailData;
import com.personal.vrpapi.core.maps.route.converter.RouteDetailConverter;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.service.RouteDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/details")
public class RouteDetailController {

    @Resource
    private RouteDetailConverter routeDetailConverter;

    @Resource
    private RouteDetailService routeDetailService;

    @PostMapping
    RouteDetailData createRouteDetail(@RequestBody CustomerRequest customerRequest) {
        return routeDetailConverter.convert(routeDetailService.createRouteDetail(customerRequest));
    }

    @GetMapping
    Page<RouteDetailData> getRouteDetails(Pageable pageable) {
        Page<RouteDetail> details = routeDetailService.getRouteDetails(pageable);
        List<RouteDetailData> routeDetailsData= routeDetailConverter.convertAll(details.getContent());
        return new PageImpl<>(routeDetailsData, pageable, details.getTotalElements());
    }
}
