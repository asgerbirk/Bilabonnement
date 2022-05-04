package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements CRUD<Customer>{

    @Override
    public List<Customer> getAllEntities() {
        Connection connection = DatabaseConnectionManager.getConnection();
        List<Customer> allCustomers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Customer tempCustomer = new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );

                allCustomers.add(tempCustomer);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong in database for customers");
        }


        return allCustomers;
    }
}
