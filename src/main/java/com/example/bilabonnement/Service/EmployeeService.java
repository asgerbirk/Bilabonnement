package com.example.bilabonnement.Service;

import com.example.bilabonnement.Model.AccessLevel;
import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

    public void whichType(String type, int id){
        switch (type) {
            case "employee":
                EmployeeRepository er = new EmployeeRepository();
                er.deleteEntity(id);
            case "car":
                CarRepository cr = new CarRepository();
                cr.deleteEntity(id);
            case "rental agreement":
                AgreementRepository ar = new AgreementRepository();
                ar.deleteEntity(id);
            case "customer":
                CustomerRepository cur = new CustomerRepository();
                cur.deleteEntity(id);
            case "damage report":
                DamageReportRepository dr = new DamageReportRepository();
                dr.deleteEntity(id);


        }
    }

}
