package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;
@InjectMocks
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
    void allRentedCars() {

        Car notRentedCar = new Car(2,"bmw","John", "black",1000,true,false);
        Car notRentedCar1 = new Car(2,"bmw","John", "black",1000,true,false);

        Car rentedCar = new Car(2,"bmw","John", "black",1000,true,true);
        Car rentedCar1 = new Car(2,"bmw","John", "black",1000,true,true);

        //checking if the car is rented
        assertEquals(underTest.allRentedCars().stream().allMatch(Car -> Car.isRented()==true)
                ,rentedCar.isRented()==true && rentedCar1.isRented() == true);

        assertEquals(rentedCar.isRented() == true, rentedCar1.isRented()==true);


        //Checking if the car is not rented
        assertEquals(notRentedCar.isRented() == false, notRentedCar1.isRented()==false);

        assertEquals(underTest.allRentedCars().stream().allMatch(Car -> Car.isRented()==false)
                ,notRentedCar.isRented()==false && notRentedCar1.isRented() == false);





    }

    @Test
@Disabled
    void totalPrice() {

    }

    @Test
    @Disabled
    void getCarFromCarNumber() {
    }

    @Test
    @Disabled
    void update() {
    }
}