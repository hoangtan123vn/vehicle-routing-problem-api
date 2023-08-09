package com.personal.vrpapi.core.maps.core.strategy.impl;

import com.personal.vrpapi.core.maps.core.service.SearchService;
import com.personal.vrpapi.core.maps.core.service.impl.InterSearchServiceImpl;
import com.personal.vrpapi.core.maps.core.strategy.LocalSearchStrategy;
import org.springframework.stereotype.Component;

@Component
public class InterSearchStrategyImpl implements LocalSearchStrategy {
    @Override
    public SearchService getService() {
        return new InterSearchServiceImpl();
    }
}
