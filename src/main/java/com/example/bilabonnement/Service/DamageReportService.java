package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Agreement;
import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Model.CarAgreement;
import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Repository.AgreementRepository;
import com.example.bilabonnement.Repository.CarRepository;
import com.example.bilabonnement.Repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    public void createDamageReport(DamageReport damageReport){
        damageReportRepository.createEntity(damageReport);
    }

    public List<Car> getAllCars(){
        List<Car> cars = carRepository.getAllEntities();
       List<Car> allCars =  cars.stream()
                .filter(damagedCars -> damagedCars.isDamaged() == false && damagedCars.isRented() == false)
               .collect(Collectors.toList());
       allCars.forEach(System.out::println);
       return allCars;
    }

    public CarAgreement getAgreementFromId(int id){
        return agreementRepository.getSingleEntity(id);
    }

    public void setDamaged(int id, boolean test){
        carService.update(id, test, "damaged");

    }
}
