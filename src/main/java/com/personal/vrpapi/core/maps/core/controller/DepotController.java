package com.personal.vrpapi.core.maps.core.controller;

import com.personal.vrpapi.core.maps.core.converter.DepotConverter;
import com.personal.vrpapi.core.maps.core.dto.request.AddDepotRequest;
import com.personal.vrpapi.core.maps.core.dto.response.DepotData;
import com.personal.vrpapi.core.maps.core.service.DepotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/depot")
public class DepotController {

    @Resource
    private DepotService depotService;

    @Resource
    private DepotConverter depotConverter;

    @PostMapping
    DepotData addDepot(@RequestBody @Valid AddDepotRequest request) {
        return depotConverter.convertDepot2Data(depotService.addDepot(request));
    }
}
