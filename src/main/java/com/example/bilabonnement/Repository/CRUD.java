package com.example.bilabonnement.Repository;

import java.util.List;

public interface CRUD <T>{

    List<T> getAllEntities();
    Object getSingleEntity(int T);
    void createEntity(T x); //TODO SPØRG NIKLAS OM HJÆLP TIL DETTE
}