package com.personal.vrpapi.core.maps.core.service.impl;

import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.core.repository.VehicleRepository;
import com.personal.vrpapi.core.maps.core.service.VehicleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Resource
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAllByIdIn(List<Long> ids) {
        List<Vehicle> vehicles = vehicleRepository.findAllByIdIn(ids);
        if (CollectionUtils.isNotEmpty(vehicles)) {
            return vehicles;
        }
        return Collections.emptyList();
    }
}
