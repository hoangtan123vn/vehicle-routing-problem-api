package com.personal.vrpapi.core.maps.core.factory.impl;

import com.personal.vrpapi.core.maps.core.enums.LocalSearchType;
import com.personal.vrpapi.core.maps.core.factory.LocalSearchFactory;
import com.personal.vrpapi.core.maps.core.service.SearchService;
import org.springframework.stereotype.Component;

@Component
public class LocalSearchFactoryImpl implements LocalSearchFactory {

    public SearchService getInstance(LocalSearchType searchType) {
        return null;
    }
}
