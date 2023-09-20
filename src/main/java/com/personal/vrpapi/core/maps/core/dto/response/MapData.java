package com.personal.vrpapi.core.maps.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MapData {
    private Long id;
    private String mapId;
    private DepotData depot;
    private List<RouteData> routes;
}
