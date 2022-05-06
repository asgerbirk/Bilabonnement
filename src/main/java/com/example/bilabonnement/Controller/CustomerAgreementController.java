package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Repository.CustomerAgreementRepository;
import com.example.bilabonnement.Repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CustomerAgreementController {

    @GetMapping
    public String registerAgreement(){
        return "registerAgreement";
    }
/*
    @PostMapping
    public String succesfullyRegisteredAgreement(WebRequest data){
        CustomerAgreementRepository agreementRepo = new CustomerAgreementRepository();

    }
*/
}
