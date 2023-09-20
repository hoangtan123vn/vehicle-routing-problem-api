package com.personal.vrpapi.core.maps.core.converter.impl;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.maps.core.converter.CustomerConverter;
import com.personal.vrpapi.core.maps.core.dto.response.CustomerData;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerConverterImpl implements CustomerConverter {
    @Override
    public CustomerData convert(final Customer customer) {
        CustomerData customerData = new CustomerData();
        customerData.setFirstName(customer.getFirstName());
        return customerData;
    }

    @Override
    public List<CustomerData> convertAll(final List<Customer> customers) {
        return null;
    }

    @Override
    public Page<CustomerData> convertAllPaging(final Page<Customer> customers) {
        Page<CustomerData> customerDatas = null;
        if (customers.hasContent()) {
            customerDatas = customers.map(this::convert);
        }
        return customerDatas;
    }
}
