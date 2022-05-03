package com.example.bilabonnement.Service;

import com.example.bilabonnement.Repository.CustomerAgreementRepository;

public class CustomerAgreementService {
    private final CustomerAgreementRepository customerAgreementRepository;

    public CustomerAgreementService(CustomerAgreementRepository customerAgreementRepository) {
        this.customerAgreementRepository = customerAgreementRepository;
    }

}
