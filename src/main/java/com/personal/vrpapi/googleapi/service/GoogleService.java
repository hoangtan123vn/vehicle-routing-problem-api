package com.personal.vrpapi.googleapi.service;

import com.personal.vrpapi.googleapi.dto.model.DistanceMatrix;
import com.personal.vrpapi.googleapi.dto.model.Geocoding;
import com.personal.vrpapi.googleapi.dto.model.Places;

public interface GoogleService {

    /**
     * Calculated single distance between origin and destination
     * @param origin
     * @param destination
     * @return
     */
    DistanceMatrix getSingleDistance(String origin, String destination);

    /**
     * get Places base on input (address search)
     * @param input
     * @return
     */
    Places getPlaces(String input);

    /**
     * Geocoding address input
     * @param address
     * @param region
     * @return
     */
    Geocoding geoCodingPlaces(String address, String region);
}
