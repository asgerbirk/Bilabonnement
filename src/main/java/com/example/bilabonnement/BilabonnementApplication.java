package com.example.bilabonnement;

import com.example.bilabonnement.Repository.CarRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BilabonnementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilabonnementApplication.class, args);
        CarRepository test = new CarRepository();
        test.getAllEntities();
    }

}
