package com.personal.vrpapi.core.maps.core.service;

import com.personal.vrpapi.core.authorization.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    /**
     * get All Customers
     * @return List<Customer>
     */
    List<Customer> getAllCustomers();

    /**
     * get ALl Customers with Paging
     * @return Page<Customer>
     */
    Page<Customer> getAllCustomersWithPaging();

    /**
     * find List<Customer> By List ids
     * @param ids
     * @return List<Customer>
     */
    List<Customer> findAllByIdIn(List<Long> ids);
}
