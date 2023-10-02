package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.base.exception.NotFoundException;
import com.personal.vrpapi.core.base.service.EntityService;
import com.personal.vrpapi.core.maps.core.converter.MapConverter;
import com.personal.vrpapi.core.maps.core.dto.request.MapRequest;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.core.enums.MapType;
import com.personal.vrpapi.core.maps.core.repository.MapRepository;
import com.personal.vrpapi.core.maps.route.service.RouteService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Component
public class MapServiceImpl implements MapService {

    @Resource
    private EntityService entityService;

    @Resource
    private MapRepository mapRepository;

    @Resource
    private MapConverter mapConverter;

    @Resource
    private CustomerService customerService;

    @Resource
    private RouteService routeService;

    @Resource
    private VehicleService vehicleService;

    @Resource
    private DepotService depotService;

    @Override
    public Map getMap(Long id) {
        Map map = entityService.findById(id, Map.class);
        if (Objects.isNull(map)) {
            throw new NotFoundException("Map not found");
        }
        return map;
    }

    @Override
    public List<Map> getMaps() {
        return mapRepository.findAllByIsActiveIsTrue();
    }

    @Override
    public Map createMap(MapRequest request) {
        Map map = new Map();
        if (CollectionUtils.isNotEmpty(request.getCustomerIds())) {
            List<Customer> customers = customerService.findAllByIdIn(request.getCustomerIds());
            map.setCustomers(customers);
        }

        if (Objects.nonNull(request.getDepotID())) {
            Depot depot = depotService.findById(request.getDepotID());
            map.setDepot(depot);
        }

        if (CollectionUtils.isNotEmpty(request.getVehicleIds())) {
            List<Vehicle> vehicles = vehicleService.findAllByIdIn(request.getVehicleIds());
            map.setVehicles(vehicles);
        }

        map.setIsActive(true);
        map.setMapType(MapType.PROCESSING);
        return mapRepository.save(map);
    }
}
