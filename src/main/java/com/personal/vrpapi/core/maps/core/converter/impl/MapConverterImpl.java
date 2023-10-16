package com.personal.vrpapi.core.maps.core.converter.impl;

import com.personal.vrpapi.core.maps.core.converter.DepotConverter;
import com.personal.vrpapi.core.maps.core.converter.MapConverter;
import com.personal.vrpapi.core.maps.core.converter.RouteConverter;
import com.personal.vrpapi.core.maps.core.dto.response.MapData;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.route.converter.RouteDetailConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class MapConverterImpl implements MapConverter {

    @Resource
    private DepotConverter depotConverter;

    @Resource
    private RouteConverter routeConverter;

    @Resource
    private RouteDetailConverter routeDetailConverter;

    @Override
    public MapData convert(Map map) {
        return MapData.builder()
                .mapId(map.getMapId())
                .id(map.getId())
                .depot(Objects.nonNull(map.getDepot()) ? depotConverter.convertDepot2Data(map.getDepot()) : null)
                .routes(CollectionUtils.isNotEmpty(map.getRoutes()) ?
                        routeConverter.convertAll(map.getRoutes()) : Collections.emptyList())
                .routeDetails(CollectionUtils.isNotEmpty(map.getNodes()) ?
                        routeDetailConverter.convertAll(map.getNodes()) : Collections.emptyList())
                .build();
    }

    @Override
    public List<MapData> convertAll(List<Map> maps) {
        if (CollectionUtils.isNotEmpty(maps)) {
            return maps.stream().map(this::convert).toList();
        }
        return Collections.emptyList();
    }
}
