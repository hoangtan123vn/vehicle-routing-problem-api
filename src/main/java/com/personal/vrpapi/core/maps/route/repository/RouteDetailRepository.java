package com.personal.vrpapi.core.maps.route.repository;

import com.personal.vrpapi.core.base.repository.CommonRepository;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDetailRepository extends CommonRepository<RouteDetail> {

    Page<RouteDetail> findAllByIsRouted(Boolean isRouted, Pageable pageable);
}
