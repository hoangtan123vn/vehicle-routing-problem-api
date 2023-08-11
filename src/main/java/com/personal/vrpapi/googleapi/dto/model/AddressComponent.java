package com.personal.vrpapi.googleapi.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressComponent {

    @JsonProperty(value = "long_name")
    private String longName;

    @JsonProperty(value = "short_name")
    private String shortName;

    @JsonProperty(value = "types")
    private List<String> types;
}
