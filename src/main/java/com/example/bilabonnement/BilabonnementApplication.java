package com.example.bilabonnement;

import com.example.bilabonnement.Repository.CustomerRepository;
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
