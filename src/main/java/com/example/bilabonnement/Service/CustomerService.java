package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {
    // Kodet af Simon

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void createCustomer(String firstname, String lastname, String email, String number, String password){
        Customer newCustomer = new Customer(firstname, lastname, email, number, password);
        customerRepository.createEntity(newCustomer);
    }

    public Customer getCustomerFromID(String customerID){
        return customerRepository.getSingleEntity(Integer.parseInt((Objects.requireNonNull(customerID))));
    }

}
