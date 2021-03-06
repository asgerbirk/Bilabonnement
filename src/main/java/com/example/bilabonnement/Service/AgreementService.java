package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Agreement;
import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Model.CarAgreement;
import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Repository.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementService {
    // Kodet af Mikkel og Simon


    private final AgreementRepository agreementRepository;
    private final CarService carService;


    @Autowired
    public AgreementService(AgreementRepository agreementRepository, CarService carService) {
        this.agreementRepository = agreementRepository;
        this.carService = carService;
    }

    public Agreement getAgreement(int id){
        return agreementRepository.getSingleEntity(id);
    }


    public void registerNewAgreement(Customer customer, int period, int price, Car car, String location){
        int totalPrice = price*period;
        CarAgreement newAgreement = new CarAgreement(customer, period, totalPrice, car, location);
        setRented(car.getCarNumber(), false);
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

