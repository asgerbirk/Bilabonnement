package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Model.DamageReport;
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
@Autowired
    public DamageReportService(DamageReportRepository damageReportRepository, CarRepository carRepository) {
        this.damageReportRepository = damageReportRepository;
        this.carRepository = carRepository;
    }

    public void createDamageReport(DamageReport damageReport){
        damageReportRepository.createEntity(damageReport);

    }

//bruges ikke, men skal måske bruges.
    public void getAllCars(String damage, int price,DamageReport damageReport){
        List<Car> cars = carRepository.getAllEntities();
       List<Car> allCars =  cars.stream()
                .filter(damagedCars -> damagedCars.isDamaged() == true && damagedCars.isRented() == false)
               .collect(Collectors.toList());
       damageReportRepository.createEntity(damageReport);

    }
}
