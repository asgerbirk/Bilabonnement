package com.example.bilabonnement.Service;
import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
