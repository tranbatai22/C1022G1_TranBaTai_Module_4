package com.example.cs_customer_mod_4.service;

import com.example.cs_customer_mod_4.dto.CustomerDTO;
import com.example.cs_customer_mod_4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> searchCustomer(String searchCustomerName, String searchCustomerEmail, String searchCustomerTypeName, Pageable pageable);

    List<Customer> findAllCustomer();

    Customer saveCustomer(Customer customer);

    Optional<Customer> findByIdCustomer(int id);
}
