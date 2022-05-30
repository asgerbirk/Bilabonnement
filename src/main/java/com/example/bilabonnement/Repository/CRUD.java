package com.example.bilabonnement.Repository;

import java.util.List;

public interface CRUD <T>{
    // Kodet af Asger, Mikkel og Simon

    List<T> getAllEntities();
    Object getSingleEntity(int T);
    void createEntity(T x);

    void updateEntity(int id, int newValue, String type);

    void deleteEntity(int id);

}