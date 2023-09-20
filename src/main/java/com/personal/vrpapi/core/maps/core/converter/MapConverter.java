package com.personal.vrpapi.core.maps.core.converter;

import com.personal.vrpapi.core.maps.core.dto.response.MapData;
import com.personal.vrpapi.core.maps.core.entity.Map;

public interface MapConverter {

    MapData convert(Map map);
}
