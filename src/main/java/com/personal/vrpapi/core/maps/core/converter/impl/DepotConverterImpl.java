package com.personal.vrpapi.core.maps.core.converter.impl;

import com.personal.vrpapi.core.maps.core.converter.DepotConverter;
import com.personal.vrpapi.core.maps.core.dto.request.DepotRequest;
import com.personal.vrpapi.core.maps.core.dto.response.DepotData;
import com.personal.vrpapi.core.maps.core.entity.Depot;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class DepotConverterImpl implements DepotConverter {
    @Override
    public DepotData convertDepot2Data(Depot depot) {
        return DepotData.builder()
                .id(depot.getId())
                .lng(depot.getLng())
                .lat(depot.getLat())
                .address(depot.getAddress())
                .email(depot.getEmail())
                .country(depot.getCountry())
                .postalCode(depot.getPostalCode())
                .build();
    }

    @Override
    public Depot convertAddDepotRequest2Depot(DepotRequest request) {
        Depot depot = new Depot();
        depot.setLat(request.getLat());
        depot.setLng(request.getLng());
        depot.setPostalCode(request.getZipCode());
        depot.setCountry(request.getCountry());
        depot.setAddress(request.getAddress());
        return depot;
    }

    @Override
    public List<DepotData> convertAll(List<Depot> depots) {
        if (CollectionUtils.isNotEmpty(depots)) {
            return depots.stream().map(this::convertDepot2Data).toList();
        }
        return Collections.emptyList();
    }
}
