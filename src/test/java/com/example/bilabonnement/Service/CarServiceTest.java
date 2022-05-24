package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;
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


        CarService test = new CarService(carRepository);


        Car notRentedCar = new Car(2,"bmw","John", "black",1000,true,false);
        Car notRentedCar1 = new Car(2,"bmw","John", "black",1000,true,false);

        Car rentedCar = new Car(2,"bmw","John", "black",1000,true,true);
        Car rentedCar1 = new Car(2,"bmw","John", "black",1000,true,true);

        boolean expected = rentedCar.isRented()==true;
        boolean invalid = notRentedCar.isRented()==false;












       //assertTrue(underTest.allRentedCars().stream().anyMatch(Cars -> rentedCar.equals(rentedCar.isRented()==true)));


       // assertEquals(expectedResult, notValidResult);

        //checking if the car is rented
       //assertEquals(underTest.allRentedCars().stream().allMatch(Car -> Car.isRented()==true)
             //  ,rentedCar.isRented()==true && rentedCar1.isRented() == true);






       // assertEquals(rentedCar.isRented() == true, rentedCar1.isRented()==true);

        //Checking if the car is not rented
       // assertEquals(underTest.allRentedCars().equals(notRentedCar), notRentedCar.isRented()==false);

      //  assertEquals(underTest.allRentedCars().stream().allMatch(Car -> Car.isRented()==false)
         //       ,notRentedCar.isRented()==false && notRentedCar1.isRented() == false);

      //  assertThat(underTest.allRentedCars().equals(rentedCar));
        // assertThat(underTest.allRentedCars().equals(notRentedCar.isRented()==false));
      //  assertThat(underTest.allRentedCars().equals(rentedCar)).isTrue();


        //assertThat(underTest.allRentedCars().equals(rentedCar)).isTrue();
    }

    @Test

    void totalPrice() {

        Car car = new Car(1,"hej", "bmw", "yellow", 100,true,true);
        Car car1 = new Car(1,"hej", "bmw", "yellow", 100,true,true);
        Car car2 = new Car(1,"hej", "bmw", "yellow", 100,true,true);

        int allCars = car1.getPrice()+car.getPrice()+car2.getPrice();

        int expected = 300;


        assertEquals(expected, underTest.priceOfAllRentedCars(allCars));



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