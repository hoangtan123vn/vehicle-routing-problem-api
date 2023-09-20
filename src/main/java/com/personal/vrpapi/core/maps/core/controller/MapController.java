package com.personal.vrpapi.core.maps.core.controller;

import com.personal.vrpapi.core.maps.core.converter.MapConverter;
import com.personal.vrpapi.core.maps.core.dto.response.MapData;
import com.personal.vrpapi.core.maps.core.service.MapService;
import com.personal.vrpapi.googleapi.dto.model.Geocoding;
import com.personal.vrpapi.googleapi.dto.model.Places;
import com.personal.vrpapi.googleapi.service.GoogleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/map")
public class MapController {

    @Resource
    private GoogleService googleService;

    @Resource
    private MapService mapService;

    @Resource
    private MapConverter mapConverter;

    @GetMapping("/places")
    Places getPlaces(@RequestParam String address) {
        return googleService.getPlaces(address);
    }

    @GetMapping("/geocoding")
    Geocoding geoCoding(@RequestParam String address, @RequestParam(required = false) String region) {
        return googleService.geoCodingPlaces(address, region);
    }

    @GetMapping("/{id}")
    MapData getMap(@PathVariable Long id) {
        return mapConverter.convert(mapService.getMap(id));
    }

}
