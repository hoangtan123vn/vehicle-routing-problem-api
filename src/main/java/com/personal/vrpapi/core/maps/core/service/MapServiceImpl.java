package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.base.exception.NotFoundException;
import com.personal.vrpapi.core.base.service.EntityService;
import com.personal.vrpapi.core.maps.core.converter.MapConverter;
import com.personal.vrpapi.core.maps.core.dto.request.AddMapRequest;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.core.enums.MapType;
import com.personal.vrpapi.core.maps.core.repository.CustomerRepository;
import com.personal.vrpapi.core.maps.core.repository.DepotRepository;
import com.personal.vrpapi.core.maps.core.repository.MapRepository;
import com.personal.vrpapi.core.maps.core.repository.VehicleRepository;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.repository.RouteRepository;
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
    private CustomerRepository customerRepository;

    @Resource
    private RouteRepository routeRepository;

    @Resource
    private VehicleRepository vehicleRepository;

    @Resource
    private DepotRepository depotRepository;

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
    public Map createMap(AddMapRequest request) {
        Map map = new Map();
        if (CollectionUtils.isNotEmpty(request.getCustomerIds())) {
            List<Customer> customers = customerRepository.findAllByIdIn(request.getCustomerIds());
            map.setCustomers(customers);
        }

        if (CollectionUtils.isNotEmpty(request.getRouteIds())) {
            List<Route> routes = routeRepository.findAllByIdIn(request.getRouteIds());
            map.setRoutes(routes);
        }

        if (Objects.nonNull(request.getDepotID())) {
            Depot depot = depotRepository.findById(request.getDepotID()).
                    orElseThrow(() -> new NotFoundException(String.format("Depot with %s not found", request.getDepotID())));
            map.setDepot(depot);
        }

        if (CollectionUtils.isNotEmpty(request.getVehicleIds())) {
            List<Vehicle> vehicles = vehicleRepository.findAllByIdIn(request.getVehicleIds());
            map.setVehicles(vehicles);
        }

        map.setMapType(MapType.PROCESSING);
        return mapRepository.save(map);
    }
}
