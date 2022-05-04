package com.example.bilabonnement.Repository;

import java.util.List;

public interface CRUD <T>{

    public List<T> getAllEntities();

    public Object getSingleEntity(int T);
}