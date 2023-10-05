package com.personal.vrpapi.core.maps.core.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteData {
    private Double costRoute;
    private Double loadingRoute;
    private Double capacityRoute;
    private StatusRoute status;
    private ZonedDateTime dateCompleted;
    private List<RouteDetailData> routeDetails;
    private VehicleData vehicleData;
}
