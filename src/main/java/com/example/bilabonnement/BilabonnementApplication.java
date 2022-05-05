package com.example.bilabonnement;

import com.example.bilabonnement.Repository.CarRepository;
import com.example.bilabonnement.Repository.CustomerAgreementRepository;
import com.example.bilabonnement.Repository.CustomerRepository;
import com.example.bilabonnement.Service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BilabonnementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilabonnementApplication.class, args);
        CarRepository car = new CarRepository();
        CustomerRepository customer = new CustomerRepository();
        CustomerAgreementRepository agreement = new CustomerAgreementRepository();

        System.out.println(agreement.getSingleEntity(1));


    }

}
