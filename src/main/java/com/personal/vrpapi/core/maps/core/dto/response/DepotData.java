package com.personal.vrpapi.core.maps.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DepotData {
    private Double lat;
    private Double lng;
    private String line1;
    private String line2;
    private String hotLine;
    private String district;
    private String city;
    private String country;
    private String postalCode;
    private String email;
    //private VehicleData vehicleData;
}
