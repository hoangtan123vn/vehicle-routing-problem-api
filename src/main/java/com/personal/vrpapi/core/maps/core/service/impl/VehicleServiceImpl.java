package com.personal.vrpapi.core.maps.core.service.impl;

import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.authorization.entity.StatusDriver;
import com.personal.vrpapi.core.authorization.service.UserService;
import com.personal.vrpapi.core.base.entity.AbstractUser;
import com.personal.vrpapi.core.base.exception.BaseException;
import com.personal.vrpapi.core.base.exception.NotFoundException;
import com.personal.vrpapi.core.maps.core.dto.request.RegisterVehicleRequest;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.core.enums.VehicleType;
import com.personal.vrpapi.core.maps.core.exception.ValidVehicleIsEmptyException;
import com.personal.vrpapi.core.maps.core.repository.VehicleRepository;
import com.personal.vrpapi.core.maps.core.service.DepotService;
import com.personal.vrpapi.core.maps.core.service.VehicleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Resource
    private VehicleRepository vehicleRepository;

    @Resource
    private UserService userService;

    @Resource
    private DepotService depotService;

    @Override
    public List<Vehicle> findAllByIdIn(List<Long> ids) {
        List<Vehicle> vehicles = vehicleRepository.findAllByIdIn(ids);
        if (CollectionUtils.isNotEmpty(vehicles)) {
            return vehicles;
        }
        return Collections.emptyList();
    }

    @Override
    public List<Vehicle> findAllByDepotAndFreeWithType(Depot depot, VehicleType type) {
        if (Objects.isNull(depot)) {
            return Collections.emptyList();
        }
        List<Vehicle> vehicles = depot.getVehicles();
        if (CollectionUtils.isEmpty(vehicles)) {
            throw new ValidVehicleIsEmptyException(String.format("Depot %s don't valid vehicles", depot.getId()));
        }
        if (VehicleType.ALL.equals(type)) {
            return vehicles;
        }
        return vehicles.stream()
                .filter(vehicle -> {
                    Driver driver = vehicle.getDriver();
                    return StatusDriver.FREE.equals(driver.getStatus()) && type.equals(vehicle.getVehicleType());
                }).toList();
    }

    @Override
    public Vehicle registerVehicle(Long driverId, RegisterVehicleRequest request) {
        AbstractUser user = userService.findById(driverId);
        Depot depot = depotService.findById(request.getDepotId());
        if (user instanceof Driver driver) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(request.getVehicleType());
            vehicle.setCapacity(request.getCapacity());
            vehicle.setDepot(depot);
            vehicle.setDriver(driver);
            return vehicleRepository.save(vehicle);
        } else {
            throw new BaseException(String.format("Can not register Vehicle for User with %s", driverId));
        }
    }

    @Override
    public Vehicle getVehicle(Long id) {
       return vehicleRepository.findById(id)
               .orElseThrow(() -> new NotFoundException(String.format("Vehicle with %s not found", id)));
    }
}
