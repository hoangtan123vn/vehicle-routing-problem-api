package com.personal.vrpapi.core.maps.route.dto.request;

import com.personal.vrpapi.core.maps.core.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InitSearchRequest {

    private List<Long> routeDetailIds;

    @NotNull("is require")
    private Long mapId;

    @NotNull("is require")
    private Long depotId;

    @NotNull("is require")
    private VehicleType vehicleType;
}
