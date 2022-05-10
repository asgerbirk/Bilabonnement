package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Model.CustomerAgreement;
import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Repository.CarRepository;
import com.example.bilabonnement.Repository.CustomerAgreementRepository;
import com.example.bilabonnement.Repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DamageReportService {

    private final DamageReportRepository damageReportRepository;
    private final CarRepository carRepository;

    private final CustomerAgreementRepository customerAgreementRepository;
    private final CarService carService;
@Autowired
    public DamageReportService(DamageReportRepository damageReportRepository, CarRepository carRepository, CustomerAgreementRepository customerAgreementRepository, CarService carService) {
        this.damageReportRepository = damageReportRepository;
        this.carRepository = carRepository;
    this.customerAgreementRepository = customerAgreementRepository;
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

    public CustomerAgreement temp (int id){
        return customerAgreementRepository.getSingleEntity(id);
    }

    public void setDamaged(int id, boolean test){
        //Car tempCar = carRepository.getSingleEntity(id);
        carService.update(id, test, "damaged");

    }
}
