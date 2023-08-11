package com.personal.vrpapi.core.maps.core.service.impl;

import com.personal.vrpapi.core.maps.core.converter.DepotConverter;
import com.personal.vrpapi.core.maps.core.dto.request.AddDepotRequest;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.repository.DepotRepository;
import com.personal.vrpapi.core.maps.core.service.DepotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepotServiceImpl implements DepotService {

    @Resource
    private DepotRepository depotRepository;

    @Resource
    private DepotConverter depotConverter;

    @Override
    public Depot addDepot(AddDepotRequest request) {
        Depot depot = depotConverter.convertAddDepotRequest2Depot(request);
        return depotRepository.save(depot);
    }
}
