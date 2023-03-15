package com.example.cs_customer_mod_4.repository;

import com.example.cs_customer_mod_4.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
