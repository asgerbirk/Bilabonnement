package com.example.bilabonnement;

import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BilabonnementApplication {

    static Employee loggeduser;

    public static void main(String[] args) {

        SpringApplication.run(BilabonnementApplication.class, args);

    }

}
