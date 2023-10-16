package com.personal.vrpapi.core.maps.core.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapData {
    private Long id;
    private String mapId;
    private DepotData depot;
    private List<RouteDetailData> routeDetails;
    private List<RouteData> routes;
}
