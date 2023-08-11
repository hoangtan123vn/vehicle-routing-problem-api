package com.personal.vrpapi.core.maps.core.dto.response;

import com.personal.vrpapi.core.maps.core.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleData {
    private Long vehicleId;
    private Double capacity;
    private VehicleType type;
}
