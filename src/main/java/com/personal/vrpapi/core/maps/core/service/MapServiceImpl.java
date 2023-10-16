package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.base.exception.NotFoundException;
import com.personal.vrpapi.core.base.service.EntityService;
import com.personal.vrpapi.core.maps.core.dto.request.MapRequest;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.enums.LocalSearchType;
import com.personal.vrpapi.core.maps.core.enums.MapType;
import com.personal.vrpapi.core.maps.core.enums.VehicleType;
import com.personal.vrpapi.core.maps.core.exception.EntityIsExistedException;
import com.personal.vrpapi.core.maps.core.factory.LocalSearchFactory;
import com.personal.vrpapi.core.maps.core.repository.MapRepository;
import com.personal.vrpapi.core.maps.route.converter.RouteDetailConverter;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import com.personal.vrpapi.core.maps.route.service.RouteDetailService;
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
    private DepotService depotService;

    @Resource
    private RouteDetailService routeDetailService;

    @Resource
    private LocalSearchFactory localSearchFactory;

    @Resource
    private CustomerService customerService;

    @Resource
    private RouteDetailConverter routeDetailConverter;

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

        if (Objects.nonNull(request.getDepotID())) {
            Depot depot = depotService.findById(request.getDepotID());
            map.setDepot(depot);
        }

        if (CollectionUtils.isNotEmpty(request.getDetailIds())) {
            List<RouteDetail> routeDetails = routeDetailService.findAllByIdIn(request.getDetailIds());
            if (CollectionUtils.isNotEmpty(routeDetails)) {
                map.setNodes(routeDetails);
            }
        }

        map.setIsActive(true);
        map.setMapType(MapType.PROCESSING);
        return mapRepository.save(map);
    }

    @Override
    public Map initMap(Long mapId) {
        Map map = getMap(mapId);
        Depot depot = map.getDepot();
        if (Objects.isNull(depot)) {
            throw new NotFoundException("Can not find depot %s in map");
        }
        List<RouteDetail> routeDetails = map.getNodes();
        if (CollectionUtils.isEmpty(routeDetails)) {
            throw new NotFoundException("Can not find nodes in map");
        }

        SearchService searchService = localSearchFactory.getInstance(LocalSearchType.INSTRA);
        //test
        List<Route> routes = searchService.search(routeDetails, depot, map, VehicleType.TRUCK2000);
        map.setRoutes(routes);
        return map;
    }

    @Override
    public Map save(Map map) {
        return mapRepository.save(map);
    }

    @Override
    public Map assignRouteDetails(Long mapId, Long routeDetailId) {
        Map map = getMap(mapId);
        List<RouteDetail> routeDetails = map.getNodes();
        RouteDetail routeDetail = routeDetailService.findById(routeDetailId);
        if (routeDetails.contains(routeDetail)) {
            throw new EntityIsExistedException(String.format("RouteDetail with %s is existed in map", routeDetailId));
        }
        routeDetail.setMap(map);
        routeDetails.add(routeDetail);
        map.setNodes(routeDetails);
        return save(map);
    }

    @Override
    public Map assignDepot(Long mapId, Long depotId) {
        Map map = getMap(mapId);
        Depot depot = depotService.findById(depotId);
        map.setDepot(depot);
        return save(map);
    }
}
