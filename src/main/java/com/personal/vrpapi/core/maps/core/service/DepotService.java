package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.maps.core.dto.request.AddDepotRequest;
import com.personal.vrpapi.core.maps.core.entity.Depot;

public interface DepotService {

    /**
     * add Depot base on request location in map
     * @param request
     * @return
     */
    Depot addDepot(AddDepotRequest request);

    /**
     * find Depot by id Depot
     * @param id
     * @return
     */
    Depot findById(Long id);
}
