package com.personal.vrpapi.core.maps.core.factory;

import com.personal.vrpapi.core.maps.core.enums.LocalSearchType;
import com.personal.vrpapi.core.maps.core.service.SearchService;

public interface LocalSearchFactory {

    /**
     *
     * @param type
     * @return instance of class implement LocalSearchStrategy;
     */
    SearchService getInstance(LocalSearchType type);
}
