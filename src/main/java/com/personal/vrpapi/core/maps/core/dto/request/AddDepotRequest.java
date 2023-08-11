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

    @JsonProperty(value = "lat")
    private Double lat;

    @JsonProperty(value = "lng")
    private Double lng;

    @JsonProperty(value ="line1")
    private String line1;

    @JsonProperty(value ="line2")
    private String line2;

    @JsonProperty(value ="district")
    private String district;

    @JsonProperty(value ="city")
    private String city;

    @JsonProperty(value ="zipCode")
    private String zipCode;

    @JsonProperty(value ="country")
    private String country;
}
