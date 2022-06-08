package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    // Kodet af Asger og Mikkel

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
        return cars.stream()
                .filter(Car::isRented)
                .collect(Collectors.toList());
    }

    public int priceOfAllRentedCars(int price){
    List<Car> allCars = allRentedCars();
        for (Car c: allCars) {
            price += c.getPrice();
        }
    return price;
    }


    public Car getCarFromCarNumber(int carNumber){
        return carRepository.getSingleEntity(carNumber);
    }

    public void update (int id, boolean available, String type){
        int value = 0;
        if(!available){
            value = 1;
        }
        carRepository.updateEntity(id,value, type);
    }

    public void createNewCar(String model, String brand, String color, int price, boolean isDamaged, boolean isRented){
    Car tmpCar = new Car(model, brand, color, price, isDamaged, isRented);
     carRepository.createEntity(tmpCar);

    }
}
