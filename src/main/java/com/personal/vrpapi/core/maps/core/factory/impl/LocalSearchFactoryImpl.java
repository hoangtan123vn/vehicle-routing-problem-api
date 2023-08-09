package com.personal.vrpapi.core.maps.core.factory.impl;

import com.personal.vrpapi.core.base.exception.BaseException;
import com.personal.vrpapi.core.maps.core.enums.LocalSearchType;
import com.personal.vrpapi.core.maps.core.factory.LocalSearchFactory;
import com.personal.vrpapi.core.maps.core.strategy.LocalSearchStrategy;
import com.personal.vrpapi.core.maps.core.strategy.impl.InstraSearchStrategyImpl;
import com.personal.vrpapi.core.maps.core.strategy.impl.InterSearchStrategyImpl;
import org.springframework.stereotype.Component;

@Component
public class LocalSearchFactoryImpl implements LocalSearchFactory {

    @Override
    public LocalSearchStrategy getInstance(LocalSearchType type) {
        if (LocalSearchType.INSTRA.equals(type)) {
            return new InstraSearchStrategyImpl();
        } else if (LocalSearchType.INTER.equals(type)) {
            return new InterSearchStrategyImpl();
        } else {
            throw new BaseException("No valid LocalSearchType");
        }
    }
}
