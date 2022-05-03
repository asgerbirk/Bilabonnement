package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Car;

import java.util.List;

public interface CRUD <T>{

    public List<Car> getAllEntities();
}
