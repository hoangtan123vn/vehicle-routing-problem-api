package com.personal.vrpapi.core.maps.core.controller;

import com.personal.vrpapi.googleapi.dto.model.Geocoding;
import com.personal.vrpapi.googleapi.dto.model.Places;
import com.personal.vrpapi.googleapi.service.GoogleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/map")
public class MapController {

    @Resource
    private GoogleService googleService;

    @GetMapping("/places")
    Places getPlaces(@RequestParam String address) {
        return googleService.getPlaces(address);
    }

    @GetMapping("/geocoding")
    Geocoding geoCoding(@RequestParam String address, @RequestParam(required = false) String region) {
        return googleService.geoCodingPlaces(address, region);
    }



//    @PostMapping

}
