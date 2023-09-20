package com.personal.vrpapi.core.maps.core.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SingleDistance {
    private Double value;

    private String origin;

    private String destination;
}
