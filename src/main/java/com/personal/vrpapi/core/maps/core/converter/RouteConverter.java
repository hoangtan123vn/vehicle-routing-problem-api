package com.personal.vrpapi.core.maps.core.converter;

import com.personal.vrpapi.core.maps.core.dto.response.RouteData;
import com.personal.vrpapi.core.maps.core.dto.response.RouteDetailData;
import com.personal.vrpapi.core.maps.route.entity.Route;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;

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
}
