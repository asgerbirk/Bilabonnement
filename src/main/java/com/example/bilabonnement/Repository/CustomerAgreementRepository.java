package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.CustomerAgreement;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerAgreementRepository implements CRUD<CustomerAgreement>{

    @Override
    public List<CustomerAgreement> getAllEntities() {
        Connection connection = DatabaseConnectionManager.getConnection();
        List<CustomerAgreement> allCustomerAgreements = new ArrayList<>();
        CustomerRepository customerRepository = new CustomerRepository();
        CarRepository carRepository = new CarRepository();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rental_agreement");
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                CustomerAgreement tempAgreement = new CustomerAgreement(
                        rs.getInt(1),
                        customerRepository.getSingleEntity(rs.getInt(2)),
                        carRepository.getSingleEntity(rs.getInt(3)),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                allCustomerAgreements.add(tempAgreement);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong in rental_agreement DB or REPO");
        }

        return allCustomerAgreements;
    }

    @Override
    public CustomerAgreement getSingleEntity(int agreementID) {
        List<CustomerAgreement> allAgreements = getAllEntities();
        CustomerAgreement tempAgreement = null;
        for (CustomerAgreement c : allAgreements) {
            if(c.getAgreementID() == agreementID){
                tempAgreement = c;
            }
        }
        return tempAgreement;
    }

    @Override
    public void createEntity(CustomerAgreement obj){
        Connection connection = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into rental_agreement values()");
            preparedStatement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something is wrong in creation of customeragreementrepo");
        }
    }



}
