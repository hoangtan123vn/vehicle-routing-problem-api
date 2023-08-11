package com.personal.vrpapi.core.maps.core.dto.response;

import com.personal.vrpapi.core.maps.route.entity.Route;
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
    private Long mapId;
    private DepotData depot;
    private List<Route> routes;
}
