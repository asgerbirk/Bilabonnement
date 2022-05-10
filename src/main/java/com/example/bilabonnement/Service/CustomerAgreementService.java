package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Model.CustomerAgreement;
import com.example.bilabonnement.Repository.CustomerAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAgreementService{


    private final CustomerAgreementRepository customerAgreementRepository;
    private final CustomerService customerService;
    private final CarService carService;


    @Autowired
    public CustomerAgreementService(CustomerAgreementRepository customerAgreementRepository, CustomerService customerService, CarService carService) {
        this.customerAgreementRepository = customerAgreementRepository;
        this.customerService = customerService;
        this.carService = carService;
    }



    public void registerNewAgreement(Customer customer, Car car, String period, int price){
        CustomerAgreement newAgreement = new CustomerAgreement(customer, car, period, price);
        customerAgreementRepository.createEntity(newAgreement);
    }

    public void update(int id, int value){
        CustomerAgreement current = customerAgreementRepository.getSingleEntity(id);
        int newPrice = current.getPrice()+value;
        customerAgreementRepository.updateEntity(id,newPrice,"total_price");


    }

    public void setRented(int id, boolean available){
        carService.update(id, available, "rented");
    }
}