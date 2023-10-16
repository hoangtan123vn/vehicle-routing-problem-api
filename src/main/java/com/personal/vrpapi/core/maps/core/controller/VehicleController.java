package com.personal.vrpapi.core.maps.core.controller;

import com.personal.vrpapi.core.maps.core.converter.VehicleConverter;
import com.personal.vrpapi.core.maps.core.dto.request.RegisterVehicleRequest;
import com.personal.vrpapi.core.maps.core.dto.response.VehicleData;
import com.personal.vrpapi.core.maps.core.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/users/vehicles")
public class VehicleController {

    @Resource
    private VehicleService vehicleService;


    @Resource
    private VehicleConverter vehicleConverter;

    @PostMapping("/{id}")
    VehicleData registerVehicle(@RequestBody RegisterVehicleRequest request, @PathVariable Long id) {
        return vehicleConverter.convert(vehicleService.registerVehicle(id, request));
    }

    @GetMapping("/{id}")
    VehicleData getVehicle(@PathVariable Long driverId) {
        return vehicleConverter.convert(vehicleService.getVehicle(driverId));
    }
}
