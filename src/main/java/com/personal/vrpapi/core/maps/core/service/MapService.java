package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.maps.core.dto.request.MapRequest;
import com.personal.vrpapi.core.maps.core.entity.Map;

import java.util.List;

public interface MapService {

    /**
     * get Map by Id
     * @param id
     * @return
     */
    Map getMap(Long id);

    /**
     * get List<Map> with active true
     * @return
     */
    List<Map> getMaps();

    /**
     * create Map
     * @param request
     * @return
     */
    Map createMap(MapRequest request);
}
