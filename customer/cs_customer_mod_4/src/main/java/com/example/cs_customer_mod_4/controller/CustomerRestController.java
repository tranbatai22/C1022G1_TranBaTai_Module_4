package com.example.cs_customer_mod_4.controller;

import com.example.cs_customer_mod_4.model.Customer;
import com.example.cs_customer_mod_4.service.ICustomerService;
import com.example.cs_customer_mod_4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<Customer> getCustomer(@RequestParam(name = "searchCustomerName", required = false, defaultValue = "") String searchCustomerName,
                                      @RequestParam(name = "searchCustomerEmail", required = false, defaultValue = "") String searchCustomerEmail,
                                      @RequestParam(name = "searchCustomerTypeName", required = false, defaultValue = "") String searchCustomerTypeName,
                                      @PageableDefault(size = 3) Pageable pageable) {

        return customerService.searchCustomer(searchCustomerName, searchCustomerEmail, searchCustomerTypeName, pageable);
    }

//    @GetMapping("")
//    public ResponseEntity<List<Customer>> getCustomer(){
//        List<Customer> customerList = customerService.findAllCustomer();
//        if (customerList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(customerList, HttpStatus.OK);
//    }
}
