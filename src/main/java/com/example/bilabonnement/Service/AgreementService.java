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


    private final AgreementRepository agreementRepository;



    @Autowired
    public AgreementService(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;

    }

    public Agreement getAgreement(int id){
        return agreementRepository.getSingleEntity(id);
    }


    public void registerNewAgreement(Customer customer, int period, int price, Car car, String location){
        int totalPrice = price*period;
        CarAgreement newAgreement = new CarAgreement(customer, period, totalPrice, car, location);
        agreementRepository.createEntity(newAgreement);
    }

    public void update(int id, int value){
        Agreement current = agreementRepository.getSingleEntity(id);
        int newPrice = current.getPrice()+value;
        agreementRepository.updateEntity(id,newPrice, "total_price");
    }

    public void setRented(String paramName, boolean available){
       carService.update(Integer.parseInt(paramName), available, "rented");
    }
}

