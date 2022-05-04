package com.example.bilabonnement.Service;

import com.example.bilabonnement.Repository.CustomerAgreementRepository;

public class CustomerAgreementService<CustomerAgreement> {
    private final CustomerAgreementRepository customerAgreementRepository;
    private final CustomerService customerService;
    private final CarService carService;

    public CustomerAgreementService(CustomerAgreementRepository customerAgreementRepository, CustomerService customerService, CarService carService) {
        this.customerAgreementRepository = customerAgreementRepository;
        this.customerService = customerService;
        this.carService = carService;
    }

    public CustomerAgreement RegisterNewAgreement(){
        return null;
    }
}