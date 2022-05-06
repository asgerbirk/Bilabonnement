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

    public void createCustomer(String firstname, String lastname, String email, String number, String password){
        Customer newCustomer = new Customer(firstname, lastname, email, number, password);
        customerRepository.createEntity(newCustomer);
    }

    public Customer getCustomerFromID(int id){
        Customer test = customerRepository.getSingleEntity(id);
        System.out.println(test.getID());
        return test;

    }

}
