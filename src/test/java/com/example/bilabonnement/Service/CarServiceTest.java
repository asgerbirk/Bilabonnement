package com.example.bilabonnement.Service;

import com.example.bilabonnement.Repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void allRentedCars() {
        underTest.allRentedCars();

         verify(carRepository).getAllEntities();



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