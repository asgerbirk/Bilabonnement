package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.CarAgreement;
import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Repository.AgreementRepository;
import com.example.bilabonnement.Repository.CarRepository;
import com.example.bilabonnement.Repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DamageReportService {

    private final DamageReportRepository damageReportRepository;
    private final CarRepository carRepository;
    private final AgreementRepository agreementRepository;
    private final CarService carService;
    
@Autowired
    public DamageReportService(DamageReportRepository damageReportRepository, CarRepository carRepository, AgreementRepository agreementRepository, CarService carService) {
        this.damageReportRepository = damageReportRepository;
        this.carRepository = carRepository;
    this.agreementRepository = agreementRepository;
    this.carService = carService;
}

    public void createDamageReport(String damage, int price){
        DamageReport newReport = new DamageReport(damage, price);
        damageReportRepository.createEntity(newReport);
    }

    public CarAgreement getAgreementFromId(int id){
        return agreementRepository.getSingleEntity(id);
    }

    public void setDamaged(int id, boolean test){
        carService.update(id, test, "damaged");
    }
}
