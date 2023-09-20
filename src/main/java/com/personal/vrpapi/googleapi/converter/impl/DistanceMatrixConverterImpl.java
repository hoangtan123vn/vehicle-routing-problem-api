package com.personal.vrpapi.googleapi.converter.impl;

import com.personal.vrpapi.core.maps.core.dto.model.SingleDistance;
import com.personal.vrpapi.googleapi.converter.DistanceMatrixConverter;
import com.personal.vrpapi.googleapi.dto.model.Distance;
import com.personal.vrpapi.googleapi.dto.model.DistanceMatrix;
import com.personal.vrpapi.googleapi.dto.model.Duration;
import com.personal.vrpapi.googleapi.dto.response.DistanceData;
import com.personal.vrpapi.googleapi.dto.response.DistanceMatrixData;
import com.personal.vrpapi.googleapi.dto.response.DurationData;
import org.springframework.stereotype.Component;

@Component
public class DistanceMatrixConverterImpl implements DistanceMatrixConverter {

    @Override
    public DistanceMatrixData convertDistanceMatrix2Data(final DistanceMatrix distanceMatrix) {
        return DistanceMatrixData.builder()
                .origin(distanceMatrix.getOriginAddresses().get(0))
                .destination(distanceMatrix.getDestinationAddress().get(0))
                .distance(buildDistanceData(distanceMatrix.getRows().get(0).getElements().get(0).getDistance()))
                .duration(buildDurationData(distanceMatrix.getRows().get(0).getElements().get(0).getDuration()))
                .build();
    }

    @Override
    public SingleDistance convertSingleDistance(DistanceMatrix distanceMatrix) {
        return SingleDistance.builder()
                .origin(distanceMatrix.getOriginAddresses().get(0))
                .destination(distanceMatrix.getDestinationAddress().get(0))
                .value(distanceMatrix.getRows().get(0).getElements().get(0).getDistance().getValue())
                .build();
    }

    private DurationData buildDurationData(final Duration duration) {
        return DurationData.builder()
                .value(duration.getValue())
                .text(duration.getText())
                .build();
    }

    private DistanceData buildDistanceData(final Distance distance) {
        return DistanceData.builder()
                .text(distance.getText())
                .value(distance.getValue())
                .build();
    }
}
