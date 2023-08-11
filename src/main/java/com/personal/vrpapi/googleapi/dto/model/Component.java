package com.personal.vrpapi.googleapi.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Component {

    @JsonProperty(value = "address_components")
    private List<AddressComponent> addressComponent;

    @JsonProperty(value = "formatted_address")
    private String formattedAddress;

    @JsonProperty(value = "geometry")
    private Geometry geometry;

    @JsonProperty(value = "place_id")
    private String placeId;

    @JsonProperty(value = "types")
    private List<String> types;

}
