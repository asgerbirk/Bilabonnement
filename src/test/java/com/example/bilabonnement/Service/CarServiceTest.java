package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CarServiceTest {
    @Mock private CarRepository carRepository;
    private CarService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CarService(carRepository);
    }


    @Test

    void allCars() {
        underTest.getAllCars();
         verify(carRepository).getAllEntities();
    }

    @Test
    void allRentedCars(){
        Car testCar = new Car(1,"hej", "bmw", "yellow", 100,true,true);
        Car testCar2 = new Car(1,"hej", "bmw", "yellow", 100,true,true);
        Car testCar3 = new Car(1,"hej", "bmw", "yellow", 100,true,false);







    }


    @Test

    void getPriceOfAllRentedCars() {
        Car car = new Car(1,"hej", "bmw", "yellow", 100,true,true);
        Car car1 = new Car(1,"hej", "bmw", "yellow", 100,true,true);
        Car car2 = new Car(1,"hej", "bmw", "yellow", 100,true,true);

        int allCars = car1.getPrice()+car.getPrice()+car2.getPrice();
        int expected = 300;

        assertEquals(expected, underTest.priceOfAllRentedCars(allCars));
    }
}
