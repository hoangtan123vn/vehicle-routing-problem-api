package com.personal.vrpapi.googleapi.converter;

import com.personal.vrpapi.googleapi.dto.model.DistanceMatrix;
import com.personal.vrpapi.googleapi.dto.response.DistanceMatrixData;

public interface DistanceMatrixConverter {

    /**
     * convert DistanceMatrix to DistanceMatrixData
     * @param distanceMatrix
     * @return
     */
    DistanceMatrixData convertDistanceMatrix2Data(final DistanceMatrix distanceMatrix);

}
