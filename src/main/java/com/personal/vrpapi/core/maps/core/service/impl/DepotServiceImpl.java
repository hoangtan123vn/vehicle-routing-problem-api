package com.personal.vrpapi.core.maps.core.service.impl;

import com.personal.vrpapi.core.maps.core.repository.DepotRepository;
import com.personal.vrpapi.core.maps.core.service.DepotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepotServiceImpl implements DepotService {

    @Resource
    private DepotRepository depotRepository;


}
