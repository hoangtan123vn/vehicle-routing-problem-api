package com.personal.vrpapi.core.maps.route.service;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.maps.core.dto.request.CustomerRequest;
import com.personal.vrpapi.core.maps.core.entity.Map;
import com.personal.vrpapi.core.maps.route.entity.RouteDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RouteDetailService {

    /**
     * find List<RouteDetail></RouteDetail>
     * @param ids
     * @return
     */
    List<RouteDetail> findAllByIdIn(List<Long> ids);

    RouteDetail createDefaultRouteDetail(Map map, Customer customer, String shippingAddress, Long sequence, Double demand,
                                         Double lat, Double lng, String postalCode);

    /**
     * create RouteDetail
     * @param request
     * @return
     */
    RouteDetail createRouteDetail(CustomerRequest request);

    /**
     * save RouteDetail
     * @param routeDetail
     * @return
     */
    RouteDetail save(RouteDetail routeDetail);

    /**
     *
     * @param id
     * @return
     */
    RouteDetail findById(Long id);

    /**
     * get RouteDetails
     * @param pageable
     * @return
     */
    Page<RouteDetail> getRouteDetails(Pageable pageable);
}
