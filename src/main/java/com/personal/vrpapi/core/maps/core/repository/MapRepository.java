package com.personal.vrpapi.core.maps.core.repository;

import com.personal.vrpapi.core.base.repository.CommonRepository;
import com.personal.vrpapi.core.maps.core.entity.Map;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MapRepository extends CommonRepository<Map> {

    /**
     * find Map by Map Id (Map Code ID)
     * @param mapId
     * @return
     */
    Optional<Map> findByMapId(String mapId);
}
