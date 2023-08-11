package com.personal.vrpapi.core.maps.core.converter;

import com.personal.vrpapi.core.maps.core.dto.request.AddDepotRequest;
import com.personal.vrpapi.core.maps.core.dto.response.DepotData;
import com.personal.vrpapi.core.maps.core.entity.Depot;

public interface DepotConverter {

    DepotData convertDepot2Data(Depot depot);

    Depot convertAddDepotRequest2Depot(AddDepotRequest request);
}
