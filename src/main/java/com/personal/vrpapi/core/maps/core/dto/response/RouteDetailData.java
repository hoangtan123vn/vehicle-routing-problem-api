package com.personal.vrpapi.core.maps.core.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.personal.vrpapi.core.maps.route.enums.StatusRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteDetailData {
    private Long driverId;
    private Long customerId;
    private Long sequence;
    private Boolean isShipped;
    private ZonedDateTime dateCompleted;
    private Boolean isRouted;
    private StatusRoute status;
}
