package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.base.service.EntityService;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.core.exception.NotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class MapServiceImpl implements MapService {

    @Resource
    private EntityService entityService;

    @Override
    public Map getMap(Long id) {
        Map map = entityService.findById(id, Map.class);
        if (Objects.isNull(map)) {
            throw new NotFoundException("Map not found");
        }
        return map;
    }
}
