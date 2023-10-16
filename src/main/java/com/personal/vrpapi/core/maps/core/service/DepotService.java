package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.maps.core.dto.request.DepotRequest;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepotService {

    /**
     * add Depot base on request location in map
     * @param request
     * @return
     */
    Depot createDepot(DepotRequest request);

    /**
     * find Depot by id Depot
     * @param id
     * @return
     */
    Depot findById(Long id);

    Page<Depot> getDepots(Pageable pageable);
}
