package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Agreement;
import com.example.bilabonnement.Model.CarAgreement;
import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Repository.AgreementRepository;
import com.example.bilabonnement.Repository.CarRepository;
import com.example.bilabonnement.Repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DamageReportService {
    // Kodet af Asger
    private final DamageReportRepository damageReportRepository;
    private final AgreementRepository agreementRepository;
    private final CarService carService;
    private final AgreementService agreementService;
    
@Autowired
    public DamageReportService(DamageReportRepository damageReportRepository, CarRepository carRepository, AgreementRepository agreementRepository, CarService carService, AgreementService agreementService) {
        this.damageReportRepository = damageReportRepository;
        this.agreementRepository = agreementRepository;
        this.carService = carService;
        this.agreementService = agreementService;
}

    public void createDamageReport(String damage, int price, int agreementID){
        agreementService.update(agreementID,price);
        CarAgreement temp = getAgreementFromId(agreementID);
        int carID = temp.getCar().getCarNumber();
        setDamaged(carID, true);
        DamageReport newReport = new DamageReport(damage, price, agreementID);
        damageReportRepository.createEntity(newReport);
    }

    public CarAgreement getAgreementFromId(int id){
        return agreementRepository.getSingleEntity(id);
    }

    public void setDamaged(int id, boolean isDamaged){
        carService.update(id, isDamaged, "damaged");
    }
}
