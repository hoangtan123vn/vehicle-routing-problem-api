package com.personal.vrpapi.core.maps.core.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepotRequest {

    @JsonProperty(value = "lat")
    @NotNull("is require")
    private Double lat;

    @JsonProperty(value = "lng")
    @NotNull("is require")
    private Double lng;

    @JsonProperty(value ="address")
    @NotBlank(message = "is require")
    private String address;

    @JsonProperty(value ="city")
    @NotBlank(message = "is require")
    private String city;

    @JsonProperty(value ="zipCode")
    @NotBlank(message = "is require")
    private String zipCode;

    @JsonProperty(value ="country")
    @NotBlank(message = "is require")
    private String country;
}
