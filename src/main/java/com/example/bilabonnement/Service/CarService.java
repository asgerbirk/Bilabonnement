package com.example.bilabonnement.Service;
import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Repository.CarRepository;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    private final CarRepository carRepository;

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
}
