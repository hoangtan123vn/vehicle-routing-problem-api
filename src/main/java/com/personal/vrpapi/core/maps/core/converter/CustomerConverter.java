package com.personal.vrpapi.core.maps.core.converter;

import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.maps.core.dto.response.CustomerData;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerConverter {

    /**
     * convert Customer to CustomerData
     * @param customer
     * @return
     */
    CustomerData convert(final Customer customer);

    /**
     * convert List<Customer> to List<CustomerData>
     * @param customers
     * @return
     */
    List<CustomerData> convertAll(final List<Customer> customers);

    /**
     * @param customers
     * convert Page<Customer> to Page<CustomerData>
     * @return
     */
    Page<CustomerData> convertAllPaging(final Page<Customer> customers);
}
