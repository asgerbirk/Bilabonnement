package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Model.CarAgreement;
import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Model.Agreement;
import com.example.bilabonnement.Repository.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementService {


    private final AgreementRepository agreementRepository;
    private final CustomerService customerService;
    private final CarService carService;


    @Autowired
    public AgreementService(AgreementRepository agreementRepository, CustomerService customerService, CarService carService) {
        this.agreementRepository = agreementRepository;
        this.customerService = customerService;
        this.carService = carService;
    }



    public void registerNewAgreement(Customer customer, String period, int price, Car car, String location){
        CarAgreement newAgreement = new CarAgreement(customer, period, price, car, location);
        agreementRepository.createEntity(newAgreement);
    }

    public void update(int id, int value){
        Agreement current = agreementRepository.getSingleEntity(id);
        int newPrice = current.getPrice()+value;
        agreementRepository.updateEntity(id,newPrice, "total_price");

    }

    public void setRented(int id, boolean available){
        carService.update(id, available, "rented");
    }
}

