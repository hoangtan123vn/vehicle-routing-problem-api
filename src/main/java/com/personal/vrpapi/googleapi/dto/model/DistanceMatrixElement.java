package com.personal.vrpapi.googleapi.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class DistanceMatrixElement {

    @JsonProperty("distance")
    private Distance distance;

    @JsonProperty("duration")
    private Duration duration;

    @JsonProperty("status")
    private String status;
}
