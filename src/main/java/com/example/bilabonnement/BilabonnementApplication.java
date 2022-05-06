package com.example.bilabonnement;

import com.example.bilabonnement.Repository.CarRepository;
import com.example.bilabonnement.Repository.CustomerAgreementRepository;
import com.example.bilabonnement.Repository.CustomerRepository;
import com.example.bilabonnement.Service.CarService;
import com.example.bilabonnement.Service.DamageReportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BilabonnementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilabonnementApplication.class, args);
        CustomerRepository cr = new CustomerRepository();
        System.out.println(cr.getAllEntities());


    }

}
