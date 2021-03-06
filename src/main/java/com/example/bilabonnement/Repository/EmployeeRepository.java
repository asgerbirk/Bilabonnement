package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Enum.AccessLevel;
import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository implements CRUD<Employee>{
    // Kodet af Mikkel
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
                    AccessLevel.valueOf(rs.getString(4))
                );
                allEmployees.add(tempEmployee);
            }

        }catch (SQLException e){
            e.printStackTrace();
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
    public Employee createEntity(Employee employee) {
        String email = employee.getEmail();
        String password = employee.getPassword();
        AccessLevel accessLevel = employee.getAccessLevel();
        Connection con = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO employee (`email`, `password`, `access_level`) VALUES (?, ?, ?)");
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, String.valueOf(accessLevel));
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void updateEntity(int id, int value, String type){
    }

    @Override
    public void deleteEntity(int id){
        Connection con = DatabaseConnectionManager.getConnection();

        try{
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM employee WHERE employee_id = ?");
            pstmt.setInt(1, id);
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
