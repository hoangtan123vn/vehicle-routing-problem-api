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
    private Long id;
    private Double lat;
    private Double lng;
    private String address;
    private String country;
    private String postalCode;
    private String email;
//    private List<VehicleData> vehicles;
}
