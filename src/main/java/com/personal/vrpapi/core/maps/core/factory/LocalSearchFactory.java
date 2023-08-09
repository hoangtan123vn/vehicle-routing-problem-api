package com.personal.vrpapi.core.maps.core.factory;

import com.personal.vrpapi.core.maps.core.enums.LocalSearchType;
import com.personal.vrpapi.core.maps.core.strategy.LocalSearchStrategy;

public interface LocalSearchFactory {

    /**
     *
     * @param type
     * @return instance of class implement LocalSearchStrategy;
     */
    LocalSearchStrategy getInstance(LocalSearchType type);
}
