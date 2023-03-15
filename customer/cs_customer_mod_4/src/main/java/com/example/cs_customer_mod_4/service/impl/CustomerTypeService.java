package com.example.cs_customer_mod_4.service.impl;

import com.example.cs_customer_mod_4.model.CustomerType;
import com.example.cs_customer_mod_4.repository.ICustomerTypeRepository;
import com.example.cs_customer_mod_4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
