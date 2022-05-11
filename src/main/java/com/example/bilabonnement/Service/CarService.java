package com.example.bilabonnement.Service;
import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
@Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.getAllEntities();
    }

    public List<Car> allRentedCars(){
        List<Car> cars = carRepository.getAllEntities();
       List<Car> allRentedCars =  cars.stream().
               filter(car -> car.isRented() == true).
               collect(Collectors.toList());
        allRentedCars.forEach(System.out::println);
        return allRentedCars;
    }

    public int totalPrice(){
    int price = 0;
    List<Car> allCars = allRentedCars();
        for (Car c: allCars) {
            price += c.getPrice();
        }
    return price;
    }

    //Da vi får værdien på carnumber ind som en string fra webRequest, parser vi int i metoden her, fordi service klassen er hovedansvarlig for logikken bag
    public Car getCarFromCarNumber(String paramName){
            Car tempcar = carRepository.getSingleEntity(Integer.parseInt(Objects.requireNonNull(paramName)));
    return tempcar;
    }

    public void update (int id, boolean available, String type){ // 1 er true, 0 er false
        //Car tempCar = carRepository.getSingleEntity(id);
        int value = 0;
        if(available){
            value = 1;
        }
        carRepository.updateEntity(id,value, type);
    }

    public String rentOrDamage(String type){
    String result;
    if(type.equals("damaged")){
        result = "damaged";
    }else {
        result = "rented";
    }
    return result;
    }


}
