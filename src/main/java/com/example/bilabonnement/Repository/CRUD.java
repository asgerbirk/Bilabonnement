package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Car;

import java.util.List;

public interface CRUD <T>{

    List<T> getAllEntities();
    Object getSingleEntity(int T);
    void createEntity(T x);
}