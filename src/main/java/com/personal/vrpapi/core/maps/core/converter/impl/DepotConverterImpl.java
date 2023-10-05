package com.personal.vrpapi.core.maps.core.converter.impl;

import com.personal.vrpapi.core.maps.core.converter.DepotConverter;
import com.personal.vrpapi.core.maps.core.dto.request.AddDepotRequest;
import com.personal.vrpapi.core.maps.core.dto.response.DepotData;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import org.springframework.stereotype.Component;

@Component
public class DepotConverterImpl implements DepotConverter {
    @Override
    public DepotData convertDepot2Data(Depot depot) {

        return null;
    }

    @Override
    public Depot convertAddDepotRequest2Depot(AddDepotRequest request) {
        Depot depot = new Depot();
        depot.setLat(request.getLat());
        depot.setLng(request.getLng());
        depot.setPostalCode(request.getZipCode());
        depot.setCountry(request.getCountry());
        return depot;
    }
}
