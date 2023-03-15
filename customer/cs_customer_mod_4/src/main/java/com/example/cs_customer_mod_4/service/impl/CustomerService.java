package com.example.cs_customer_mod_4.service.impl;

import com.example.cs_customer_mod_4.dto.CustomerDTO;
import com.example.cs_customer_mod_4.model.Customer;
import com.example.cs_customer_mod_4.repository.ICustomerRepository;
import com.example.cs_customer_mod_4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Page<Customer> searchCustomer(String searchCustomerName, String searchCustomerEmail, String searchCustomerTypeName, Pageable pageable) {
        return customerRepository.findByCustomerNameContainingAndCustomerEmailContainingAndCustomerType_CustomerTypeName(searchCustomerName, searchCustomerEmail, searchCustomerTypeName, pageable);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByIdCustomer(int id) {
        return customerRepository.findById(id);
    }
}
