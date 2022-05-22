package com.example.bilabonnement.Model;

import com.example.bilabonnement.Enum.AccessLevel;

public class Employee {

    private int employee_id;

    private String email;

    private String password;

    private AccessLevel accessLevel;

    public Employee (String email, String password, AccessLevel accessLevel){
        this.email = email;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public Employee (int employee_id, String email, String password, AccessLevel accessLevel){
        this.employee_id = employee_id;
        this.email = email;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}
