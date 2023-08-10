package com.personal.vrpapi.core.maps.route.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DistanceRequest {

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("destination")
    private String destination;
}
