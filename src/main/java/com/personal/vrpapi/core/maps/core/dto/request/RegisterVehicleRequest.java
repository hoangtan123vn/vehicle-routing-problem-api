package com.personal.vrpapi.core.maps.core.dto.request;

import com.personal.vrpapi.core.maps.core.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterVehicleRequest {

    private Long depotId;

    private VehicleType vehicleType;

    private Double capacity;
}
