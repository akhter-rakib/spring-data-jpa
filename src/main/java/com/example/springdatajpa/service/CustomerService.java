package com.example.springdatajpa.service;

import com.example.springdatajpa.dao.CustomerRepository;
import com.example.springdatajpa.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

}
