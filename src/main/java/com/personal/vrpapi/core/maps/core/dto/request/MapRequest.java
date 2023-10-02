package com.personal.vrpapi.core.maps.core.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MapRequest {

    @JsonProperty("customers")
    private List<Long> customerIds;

    @JsonProperty("depot")
    private Long depotID;

    @JsonProperty("vehicles")
    private List<Long> vehicleIds;
}
