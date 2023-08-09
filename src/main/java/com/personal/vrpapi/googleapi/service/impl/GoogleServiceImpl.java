package com.personal.vrpapi.googleapi.service.impl;

import com.personal.vrpapi.core.base.service.AbstractService;
import com.personal.vrpapi.googleapi.GoogleProperties;
import com.personal.vrpapi.googleapi.service.GoogleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GoogleServiceImpl extends AbstractService implements GoogleService {

    @Resource
    private GoogleProperties properties;

    @Override
    public Long getDistance(String origin, String destination) {
        return null;
    }

}
