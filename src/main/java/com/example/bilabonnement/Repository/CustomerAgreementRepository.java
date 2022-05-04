package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Model.CustomerAgreement;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerAgreementRepository implements CRUD<CustomerAgreement>{

    @Override
    public List<CustomerAgreement> getAllEntities() {
       /* Connection connection = DatabaseConnectionManager.getConnection();
        List<CustomerAgreement> allCustomerAgreements = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rental_agreement");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                CustomerAgreement tempCustomerAgreement = new CustomerAgreement(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );

                allCustomerAgreements.add(tempCustomerAgreement);

            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong in rental_rentalagreement DB or REPO");
        }

        return allCustomerAgreements;*/
        return null;
    }

    @Override
    public Object getSingleEntity(int T) {
        return null;
    }


}
