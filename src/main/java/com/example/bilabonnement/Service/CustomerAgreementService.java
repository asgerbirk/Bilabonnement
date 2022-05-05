package com.example.bilabonnement.Service;

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



    public CustomerAgreement RegisterNewAgreement(){



        return null;
    }
}