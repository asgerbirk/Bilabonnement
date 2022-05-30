package com.example.bilabonnement.Service;

import com.example.bilabonnement.Enum.AccessLevel;
import com.example.bilabonnement.Enum.Pages;
import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    // Kodet af Mikkel og Simon
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(String mail, String password, AccessLevel accessLevel){
        Employee newEmployee = new Employee(mail, password, accessLevel);
        employeeRepository.createEntity(newEmployee);
    }

    public Employee getEmployeeFromEmail(String email){
        List<Employee> allEmployees = employeeRepository.getAllEntities();
        for (Employee e: allEmployees){
            if (e.getEmail().equals(email)){
                return e;
            }
        }
        return null;
    }
    public String returnPageIfAuthorized(Object loggedEmployee, Pages reqPage){
        AccessLevel emplAcsLvl = (AccessLevel) loggedEmployee;
        if(loggedEmployee == null){
            return "redirect:/index";
        }
        switch (reqPage){
            case masterPage:
                if(emplAcsLvl == AccessLevel.MASTER){
                    return "masterPage";
                }
                break;
            case adminPage:
                if(emplAcsLvl == AccessLevel.ADMIN || emplAcsLvl == AccessLevel.MASTER){
                    return "adminPage";
                }
                break;
            case employeePage:
                if(emplAcsLvl != AccessLevel.USER){
                    return "employeePage";
                }
                break;
            case userPage:
                return "userPage";

            case delete:
                if(emplAcsLvl == AccessLevel.MASTER){
                    return "delete";
                }
                break;
            case createemployee:
                if(emplAcsLvl == AccessLevel.MASTER || emplAcsLvl == AccessLevel.ADMIN){
                    return "createemployee";
                }
                break;
            case damageReport:
                if(emplAcsLvl != AccessLevel.USER){
                    return "damageReport";
                }
                break;
            case registerAgreement:
                if(emplAcsLvl != AccessLevel.USER){
                    return "registerAgreement";
                }
                break;
            case rentedCars:
                return "rentedCars";
            case allCars:
                return "allCars";
            default:
                return "redirect:/index";
        }
        return "redirect:/error";
    }

    public String returnSessionPage(Object loggedEmployee){
        AccessLevel emplAcsLvl = (AccessLevel) loggedEmployee;
        switch (emplAcsLvl){
            case MASTER:
                return "redirect:/masterPage";
            case ADMIN:
                return "redirect:/adminPage";
            case EMPLOYEE:
                return "redirect:/employeePage";
            case USER:
                return "redirect:/userPage";
            default:
                return "redirect:/index";
        }
    }

    public AccessLevel giveAccessLevel(String email, String password){
        Employee tempEmployee = getEmployeeFromEmail(email);
        if (tempEmployee.getPassword().equals(password)){
            return tempEmployee.getAccessLevel();
        }
        return AccessLevel.USER;
    }

    public void whichType(String type, int id){
        switch (type) {
            case "employee":
                employeeRepository.deleteEntity(id);
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
