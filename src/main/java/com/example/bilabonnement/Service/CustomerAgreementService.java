package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Model.CarAgreement;
import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Model.Agreement;
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



    public void registerNewAgreement(Customer customer, String period, String price, Car car, String locaion){
        CarAgreement newAgreement = new CarAgreement(customer, period, price, car, locaion);
        customerAgreementRepository.createEntity(newAgreement);
    }
}