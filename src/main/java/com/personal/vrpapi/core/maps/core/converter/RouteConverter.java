package com.personal.vrpapi.core.maps.core.converter;

import com.personal.vrpapi.core.base.entity.AbstractNode;
import com.personal.vrpapi.core.maps.core.dto.response.RouteData;
import com.personal.vrpapi.core.maps.core.dto.response.RouteDetailData;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;

import java.util.List;

public interface RouteConverter {

    /**
     * convert Route to RouteData
     * @param route
     * @return
     */
    RouteData convert(Route route);

    /**
     * convert RouteDetail to RouteDetailData
     * @param route
     * @return
     */
    RouteDetailData convert(RouteDetail route);

    /**
     *
     * @return
     */
    Route buildRoute(Double costRoute, Double loadingRoute, List<AbstractNode> nodes,
                     Map map, Vehicle vehicle);


    /**
     *
     * @param route
     * @return
     */
    List<RouteData> convertAll(List<Route> route);
}
