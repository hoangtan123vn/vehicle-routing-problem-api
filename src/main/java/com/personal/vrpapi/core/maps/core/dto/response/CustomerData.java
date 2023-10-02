package com.personal.vrpapi.core.maps.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerData {
    private Long id;
    private String firstName;
    private BigDecimal demand;
}
