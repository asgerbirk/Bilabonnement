package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

//Kodet af Asger
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

        List<Car> cars = underTest.allRentedCars();
        cars.add(testCar);
        cars.add(testCar2);
        cars.add(testCar3);



        assertTrue(cars.size()==3);

        assertThat(cars.get(0).isRented()).isTrue();
        assertThat(cars.get(1).isRented()).isTrue();
        assertThat(cars.get(2).isRented()).isFalse();


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
