package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CarRepositoryTest {
        @Mock
        private CarRepository underTest;

        @BeforeEach
        void setUp() {
            underTest = new CarRepository();

        }


    @Test
    void getSingleEntity() {
        Car car1 = new Car(1,"hej1", "bmw", "yellow", 100,true,true);
        Car car2 = new Car(2,"hej2", "bmw", "yellow", 100,true,true);
        Car car3 = new Car(3,"hej3", "bmw", "yellow", 100,true,true);
        Car car4 = new Car(4,"hej4", "bmw", "yellow", 100,true,true);

        assertEquals(car1, underTest.getSingleEntity(1));
    }

}