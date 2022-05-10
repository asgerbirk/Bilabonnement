package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Employee;

import java.util.List;

public class EmployeeRepository implements CRUD<Employee>{
    @Override
    public List<Employee> getAllEntities() {
        return null;
    }

    @Override
    public Object getSingleEntity(int T) {
        return null;
    }

    @Override
    public void createEntity(Employee entity) {

    }
    @Override
    public void updateEntity(int id, int value,String type){

    }
}
