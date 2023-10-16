package com.personal.vrpapi.core.maps.core.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private Long customerId;
    private Double lat;
    private Double lng;
    private Long sequence;
    private Double demand;
    private String postalCode;
    private String shippingAddress;
}
