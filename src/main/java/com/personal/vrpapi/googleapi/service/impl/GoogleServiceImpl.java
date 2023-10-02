package com.personal.vrpapi.googleapi.service.impl;

import com.personal.vrpapi.core.maps.core.dto.model.SingleDistance;
import com.personal.vrpapi.googleapi.GoogleProperties;
import com.personal.vrpapi.googleapi.converter.DistanceMatrixConverter;
import com.personal.vrpapi.googleapi.dto.model.DistanceMatrix;
import com.personal.vrpapi.googleapi.dto.model.Geocoding;
import com.personal.vrpapi.googleapi.dto.model.Places;
import com.personal.vrpapi.googleapi.service.AbstractGoogleService;
import com.personal.vrpapi.googleapi.service.GoogleService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class GoogleServiceImpl extends AbstractGoogleService implements GoogleService {

    @Resource
    private GoogleProperties properties;

    @Resource
    private DistanceMatrixConverter distanceMatrixConverter;

    private static final String API_DISTANCEMATRIX  = "/distancematrix/json?";

    private static final String API_PLACE = "/place/findplacefromtext/json?";

    private static final String API_GEOCODING = "/geocode/json?";

    private static final String AMPERSAND = "&";

    @Override
    public DistanceMatrix getSingleDistance(final String origin, final String destination) {
        String originParam = "origins=" + origin;
        String destinationParam = "destinations=" + destination;
        String key = "key="+ properties.getApikey();
        String endpoint = properties.getUrl().concat(API_DISTANCEMATRIX).concat(originParam).concat(AMPERSAND + destinationParam).concat(AMPERSAND + key);
        return executeRequest(endpoint, null, HttpMethod.GET, DistanceMatrix.class);
    }

    @Override
    public Places getPlaces(String input) {
        String searchAddress = "input=" + input;
        String key = "key="+ properties.getApikey();
        String endpoint = properties.getUrl().concat(API_PLACE).concat(searchAddress).concat(AMPERSAND + key);
        return executeRequest(endpoint, null, HttpMethod.GET, Places.class);
    }

    @Override
    public Geocoding geoCodingPlaces(String address, String localeRegion) {
        String input = "address=" + address;
        String key = "key="+ properties.getApikey();
        String endpoint = properties.getUrl().concat(API_GEOCODING).concat(input).concat(AMPERSAND + key);
        if (Objects.nonNull(localeRegion)) {
            String region = "region=" + localeRegion;
            endpoint = properties.getUrl().concat(API_GEOCODING).concat(input).concat(AMPERSAND + region).concat(AMPERSAND + key);
        }
        return executeRequest(endpoint, null, HttpMethod.GET, Geocoding.class);
    }

    @Override
    public Double getValueSingleDistance(String origin, String destination) {
        DistanceMatrix distanceMatrix = getSingleDistance(origin, destination);
        SingleDistance singleDistance = distanceMatrixConverter.convertSingleDistance(distanceMatrix);
        return distanceMatrixConverter.convertValueSingleDistance(singleDistance);
    }
}
