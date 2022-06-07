package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements CRUD<Customer>{
    // Kodet af Mikkel

    @Override
    public List<Customer> getAllEntities() {
        Connection con = DatabaseConnectionManager.getConnection();
        List<Customer> allCustomers = new ArrayList<>();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM customer");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Customer tempCustomer = new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                allCustomers.add(tempCustomer);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong in database for customers");
        }
        return allCustomers;
    }

    @Override
    public Customer getSingleEntity(int customerId) {
        List<Customer> allCustomers = getAllEntities();
        Customer tempCustomer = null;
        for (Customer c : allCustomers) {
            if(c.getID()==customerId){
                tempCustomer=c;
                tempCustomer.setID(c.getID());
            }
        }
        return tempCustomer;
    }

    @Override
    public Car createEntity(Customer customer){
            String firstname = customer.getFirstname();
            String surname = customer.getSurname();
            String email = customer.getEmail();
            String number = customer.getPhoneNumber();
            String password = customer.getPassword();
            Connection con = DatabaseConnectionManager.getConnection();
            try{
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO customer (`firstname`, `lastname`, `email`, `phone_number`, `password`) VALUES (?, ?, ?, ?, ?)");
                pstmt.setString(1,firstname);
                pstmt.setString(2,surname);
                pstmt.setString(3,email);
                pstmt.setString(4,number);
                pstmt.setString(5,password);
                pstmt.execute();
            }catch(Exception e){
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
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM customer WHERE customer_id = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

