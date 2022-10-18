package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.CustomerDto;
import com.ideas2it.bookmymovie.model.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDto addCustomer(Customer customer);
    CustomerDto removeCustomer(int customerId);
    CustomerDto updateCustomer(Customer customer);
    List<CustomerDto> viewCustomerList();
    CustomerDto viewCustomer(int customerId);
}
