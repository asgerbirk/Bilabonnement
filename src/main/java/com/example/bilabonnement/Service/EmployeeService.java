package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.AccessLevel;
import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    public Employee getEmployeeFromEmail(String email){
        EmployeeRepository er = new EmployeeRepository();
        List<Employee> allEmployees = er.getAllEntities();
        for (Employee e: allEmployees){
            if (e.getEmail().equals(email)){
                return e;
            }
        }
        return null;
    }

    public AccessLevel loginValidator(String email, String password){
        Employee tempEmployee = getEmployeeFromEmail(email);
        if (tempEmployee.getPassword().equals(password)){
            return tempEmployee.getAccessLevel();
        }
        return AccessLevel.USER;
    }

}
