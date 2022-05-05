package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.getAllEntities();
    }

}
