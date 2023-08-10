package com.personal.vrpapi.core.maps.core.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddDepotRequest {

    @JsonProperty("line1")
    private String line1;

    @JsonProperty("line2")
    private String line2;

    @JsonProperty("district")
    private String district;

    @JsonProperty("city")
    private String city;

    @JsonProperty("line1")
    private String zipCode;

    @JsonProperty("line1")
    private String country;
}
