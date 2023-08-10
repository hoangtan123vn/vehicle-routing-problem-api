package com.personal.vrpapi.googleapi.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DistanceMatrix {

    @JsonProperty("destination_addresses")
    private List<String> destinationAddress;

    @JsonProperty("origin_addresses")
    private List<String> originAddresses;

    @JsonProperty("rows")
    private List<DistanceMatrixRow> rows;

    @JsonProperty("status")
    private String status;
}
