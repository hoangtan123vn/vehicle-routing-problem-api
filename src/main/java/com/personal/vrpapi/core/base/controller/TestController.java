package com.personal.vrpapi.core.base.controller;

import com.personal.vrpapi.core.base.service.EntityService;
import com.personal.vrpapi.core.maps.core.converter.CustomerConverter;
import com.personal.vrpapi.core.maps.core.dto.response.CustomerData;
import com.personal.vrpapi.core.maps.core.entity.Vehicle;
import com.personal.vrpapi.core.maps.core.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private EntityService entityService;

    @Resource
    private CustomerService customerService;

    @Resource
    private CustomerConverter customerConverter;

    @GetMapping("/vehicles")
    public Page<Vehicle> getVehicles() {
        return entityService.search(Vehicle.class, (root, query, criteriaBuilder)  -> {
            return null;
        }, PageRequest.of(0, 5));
    }

    @GetMapping("/customers")
    public Page<CustomerData> getCustomers() {
        return customerConverter.convertAllPaging(customerService.getAllCustomersWithPaging());
    }
}
