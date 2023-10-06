package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.maps.core.entity.Depot;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.enums.VehicleType;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;

import java.util.List;

public interface SearchService {

    List<Route> search(List<RouteDetail> routeDetails , Depot depot, Map map, VehicleType type);
}
