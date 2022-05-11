package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements CRUD<Employee>{
    @Override
    public List<Employee> getAllEntities() {
        Connection con = DatabaseConnectionManager.getConnection();
        List<Employee> allEmployees = new ArrayList<>();
        try{
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employee");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Employee tempEmployee = new Employee(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                );
                allEmployees.add(tempEmployee);
            }



        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong in database for employees");
        }
        return allEmployees;
    }

    @Override
    public Object getSingleEntity(int employee_id) {
        List<Employee> allEmployees = getAllEntities();
        Employee tempEmployee = null;
        for (Employee e: allEmployees) {
            if(e.getEmployee_id()== employee_id){
                tempEmployee = e;
                tempEmployee.setEmployee_id(e.getEmployee_id());
            }
        }
        return tempEmployee;
    }


    @Override
    public void createEntity(Employee employee) {
        /*
        String email = employee.getEmail();
        String password = employee.getPassword();
        AccessLevel accessLevel = employee.getAccessLevel();
//TODO DER ER ARBEJDE HER, DER ER DOUBLE MERGE
        Connection con = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO employee (`email`, `password`, `access_level`) VALUES (?, ?, ?)");
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, String.valueOf(accessLevel));
            stmt.execute();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO employee (`email`, `password`, `department`) VALUES (?, ?, ?)");
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, department);
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void updateEntity(int id, int value,String type){

    }
    /*

         */
    }

    @Override
    public void updateEntity(int id, int newValue, String type) {

    }
}
