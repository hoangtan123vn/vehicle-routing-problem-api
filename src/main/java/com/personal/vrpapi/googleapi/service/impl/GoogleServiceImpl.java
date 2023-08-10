package com.personal.vrpapi.googleapi.service.impl;

import com.personal.vrpapi.googleapi.GoogleProperties;
import com.personal.vrpapi.googleapi.dto.model.DistanceMatrix;
import com.personal.vrpapi.googleapi.dto.model.Places;
import com.personal.vrpapi.googleapi.exception.ApiCommunicationException;
import com.personal.vrpapi.googleapi.service.AbstractGoogleService;
import com.personal.vrpapi.googleapi.service.GoogleService;
import okhttp3.Response;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class GoogleServiceImpl extends AbstractGoogleService implements GoogleService {

    private static final String API_DISTANCEMATRIX  = "/distancematrix/json?";

    private static final String API_PLACE = "/place/findplacefromtext/json?";

    private static final String API_GEOCODING = "/geocode/json?";

    private static final String AMPERSAND="&";

    @Resource
    private GoogleProperties properties;

    @Override
    public DistanceMatrix getSingleDistance(final String origin, final String destination) {
        String originParam = "origins=" + origin;
        String destinationParam = "destinations=" + destination;
        String key = "key="+ properties.getApikey();

        String endpoint = properties.getUrl().concat(API_DISTANCEMATRIX).concat(originParam).concat(AMPERSAND + destinationParam).concat(AMPERSAND + key);
        Response response = executeRequest(endpoint, null, HttpMethod.GET);
        if (response.isSuccessful()) {
            DistanceMatrix distanceMatrix = readValue(DistanceMatrix.class, response);
            if (Objects.nonNull(distanceMatrix)) {
                return distanceMatrix;
            }
        }
        throw new ApiCommunicationException("Api communicate exception" + response.message());
    }

    @Override
    public Places getPlaces(String input) {
        String searchAddress = "input=" + input;
        String key = "key="+ properties.getApikey();
        String endpoint = properties.getUrl().concat(API_PLACE).concat(searchAddress).concat(AMPERSAND + key);
        Response response = executeRequest(endpoint, null, HttpMethod.GET);
        if (response.isSuccessful()) {
            Places places = readValue(Places.class, response);
            if (Objects.nonNull(places)) {
                return places;
            }
        }
        throw new ApiCommunicationException("Api communicate exception" + response.message());
    }


}
