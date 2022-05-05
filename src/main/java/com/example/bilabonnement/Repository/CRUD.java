package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Car;

import java.util.List;

public interface CRUD <T>{

    public List<T> getAllEntities();

    public Object getSingleEntity(int T);

    public void createEntity(T entity);



}