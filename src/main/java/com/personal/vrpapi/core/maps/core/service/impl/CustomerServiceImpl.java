package com.personal.vrpapi.core.maps.core.service.impl;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.base.service.EntityService;
import com.personal.vrpapi.core.maps.core.repository.CustomerRepository;
import com.personal.vrpapi.core.maps.core.service.CustomerService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private EntityService entityService;
    @Override
    public List<Customer> getAllCustomers() {
        return entityService.search(Customer.class, (root, query, criteriaBuilder) -> {
            return null;
        });
    }

    @Override
    public Page<Customer> getAllCustomersWithPaging() {
        return entityService.search(Customer.class, (root, query, criteriaBuilder) -> {
            return null;
        }, PageRequest.of(0, 5));
    }

    @Override
    public List<Customer> findAllByIdIn(List<Long> ids) {
        List<Customer> customers = customerRepository.findAllByIdIn(ids);
        if (CollectionUtils.isNotEmpty(customers)) {
            return customers;
        }
        return Collections.emptyList();
    }

    @Override
    public Customer findById(Long customerId) {
        return entityService.findById(customerId, Customer.class);
    }
}
