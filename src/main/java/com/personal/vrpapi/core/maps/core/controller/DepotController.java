package com.personal.vrpapi.core.maps.core.controller;

import com.personal.vrpapi.core.maps.core.converter.DepotConverter;
import com.personal.vrpapi.core.maps.core.dto.request.DepotRequest;
import com.personal.vrpapi.core.maps.core.dto.response.DepotData;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.service.DepotService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/depots")
public class DepotController {

    @Resource
    private DepotService depotService;

    @Resource
    private DepotConverter depotConverter;

    @PostMapping
    DepotData createDepot(@RequestBody @Valid DepotRequest request) {
        return depotConverter.convertDepot2Data(depotService.createDepot(request));
    }

    @GetMapping
    Page<DepotData> getDepots(Pageable pageable) {
        Page<Depot> depots = depotService.getDepots(pageable);
        List<DepotData> depotDatas = depotConverter.convertAll(depots.getContent());
        return new PageImpl<>(depotDatas, pageable, depots.getTotalElements());
    }
}
