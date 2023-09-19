package com.personal.vrpapi.core.maps.core.converter;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.maps.core.dto.response.CustomerData;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerConverter {

    CustomerData convert(Customer customer);

    List<CustomerData> convertAll(List<Customer> customers);

    Page<CustomerData> convertAllPaging(Page<Customer> customers);
}
