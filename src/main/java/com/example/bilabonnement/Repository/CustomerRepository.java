package com.example.bilabonnement.Repository;

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
            }

        }

        return tempCustomer;
    }

    //@Override
    public void createEntity(Customer customer){
            String firstname = customer.getFirstname();
            String surname = customer.getSurname();
            String email = customer.getEmail();
            String number = customer.getPhoneNumber();
            String password = customer.getPassword();
            //Customer testcustomer = new Customer(firstname, surname, email, number, password);

            Connection conn = DatabaseConnectionManager.getConnection();
            try{
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer (`firstname`, `lastname`, `email`, `phone_number`, `password`) VALUES (?,?,?,?,?)");
                stmt.setString(1,firstname);
                stmt.setString(2,surname);
                stmt.setString(3,email);
                stmt.setString(4,number);
                stmt.setString(5,password);
                //System.out.println(stmt);
                stmt.execute();

            }catch(Exception e){
                e.printStackTrace();
            }
            //return testcustomer;
    }
}
