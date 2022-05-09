package com.example.bilabonnement.Repository;

import java.util.List;

public interface CRUD <T>{

    List<T> getAllEntities();
    Object getSingleEntity(int T);
    void createEntity(T x);

    void updateEntity(int id, int newValue);
}