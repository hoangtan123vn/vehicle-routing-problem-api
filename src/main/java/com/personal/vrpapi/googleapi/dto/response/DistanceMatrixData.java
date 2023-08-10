package com.personal.vrpapi.googleapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DistanceMatrixData {

    private String origin;

    private String destination;

    private DistanceData distance;

    private DurationData duration;
}
