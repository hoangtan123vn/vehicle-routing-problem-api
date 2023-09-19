package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.authorization.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Page<Customer> getAllCustomersWithPaging();
}
