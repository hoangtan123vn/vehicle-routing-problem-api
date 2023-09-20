package com.personal.vrpapi.googleapi.converter;

import com.personal.vrpapi.core.maps.core.dto.model.SingleDistance;
import com.personal.vrpapi.googleapi.dto.model.DistanceMatrix;
import com.personal.vrpapi.googleapi.dto.response.DistanceMatrixData;

public interface DistanceMatrixConverter {

    /**
     * convert DistanceMatrix to DistanceMatrixData
     * @param distanceMatrix
     * @return DistanceMatrixData
     */
    DistanceMatrixData convertDistanceMatrix2Data(final DistanceMatrix distanceMatrix);

    /**
     * convert DistanceMatrix to SingleDistance
     * @param distanceMatrix
     * @return SingleDistance
     */
    SingleDistance convertSingleDistance(final DistanceMatrix distanceMatrix);
}
