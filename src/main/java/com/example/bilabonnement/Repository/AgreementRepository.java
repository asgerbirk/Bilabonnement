package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.CarAgreement;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AgreementRepository implements CRUD<CarAgreement>{

    @Override
    public List<CarAgreement> getAllEntities() {
        Connection connection = DatabaseConnectionManager.getConnection();
        List<CarAgreement> allAgreements = new ArrayList<>();
        CustomerRepository customerRepository = new CustomerRepository();
        CarRepository carRepository = new CarRepository();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rental_agreement");
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                CarAgreement tempAgreement = new CarAgreement(
                        rs.getInt(1),
                        customerRepository.getSingleEntity(rs.getInt(2)),
                        rs.getString(4),
                        rs.getInt(5),
                        carRepository.getSingleEntity(rs.getInt(3)),
                        rs.getString(6)
                );
                allAgreements.add(tempAgreement);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong in rental_agreement DB or REPO");
        }

        return allAgreements;
    }

    @Override
    public CarAgreement getSingleEntity(int agreementID) {
        List<CarAgreement> allAgreements = getAllEntities();
        CarAgreement tempAgreement = null;
        for (CarAgreement c : allAgreements) {
            if(c.getAgreementID() == agreementID){
                tempAgreement = c;
            }
        }
        return tempAgreement;
    }

    @Override
    public void createEntity(CarAgreement obj){
        Connection connection = DatabaseConnectionManager.getConnection();
        int customerID = obj.getCustomer().getID();
        int carNumber = obj.getCar().getCarNumber();
        String period = obj.getPeriod();
        int price = obj.getPrice();
        String location = obj.getLocation();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into rental_agreement " +
                            "(`customer_id`, `car_number`, `rental_period`, `total_price`, `location`)" +
                            " values(?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, customerID);
            preparedStatement.setInt(2, carNumber);
            preparedStatement.setString(3, period);
            preparedStatement.setInt(4, price);
            preparedStatement.setString(5, location);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something is wrong in creation of customeragreementrepo");
        }
    }

    @Override
    public void updateEntity(int id, int value, String type){
        Connection connection = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement stmst = connection.prepareStatement("UPDATE rental_agreement SET "+type+" = ? WHERE agreement_id = ?;");
            //stmst.setString(1, type);
            stmst.setInt(1,value);
            stmst.setInt(2, id);
            System.out.println(stmst);
            stmst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

}
