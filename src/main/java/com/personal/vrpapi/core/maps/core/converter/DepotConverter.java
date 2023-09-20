package com.personal.vrpapi.core.maps.core.converter;

import com.personal.vrpapi.core.maps.core.dto.request.AddDepotRequest;
import com.personal.vrpapi.core.maps.core.dto.response.DepotData;
import com.personal.vrpapi.core.maps.core.entity.Depot;

public interface DepotConverter {

    /**
     * Convert Depot to DepotData
     * @param depot
     * @return DepotData
     */
    DepotData convertDepot2Data(Depot depot);

    /**
     * Convert AddDepotRequest to Depot
     * @param request
     * @return Depot
     */
    Depot convertAddDepotRequest2Depot(AddDepotRequest request);
}
