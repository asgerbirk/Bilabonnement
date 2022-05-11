package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {


    public String loginValidator(String email, String password){
        EmployeeRepository er = new EmployeeRepository();
        List<Employee> allEmployees = er.getAllEntities();

        for (Employee e: allEmployees) {
            if(e.getEmail().equals(email) && e.getPassword().equals(password)){
                return e.getDepartment();
            }
        }
        return "fejl";
    }

}
