package com.example.bilabonnement.Model;

public class Employee {

    private int employee_id;

    private String email;

    private String password;

    private String department;

    public Employee (String email, String password, String department){
        this.email = email;
        this.password = password;
        this.department = department;
    }

}
