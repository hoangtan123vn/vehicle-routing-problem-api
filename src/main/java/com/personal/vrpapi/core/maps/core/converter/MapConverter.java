package com.personal.vrpapi.core.maps.core.converter;

import com.personal.vrpapi.core.maps.core.dto.response.MapData;
import com.personal.vrpapi.core.maps.core.entity.Map;

import java.util.List;

public interface MapConverter {

    /**
     * convert Map to MapData
     * @param map
     * @return
     */
    MapData convert(Map map);

    /**
     * convert List<Map> to List<MapData>
     * @param map
     * @return
     */
    List<MapData> convertAll(List<Map> map);
}
