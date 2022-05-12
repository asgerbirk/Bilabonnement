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
        Connection con = DatabaseConnectionManager.getConnection();
        List<CarAgreement> allAgreements = new ArrayList<>();
        CustomerRepository customerRepository = new CustomerRepository();
        CarRepository carRepository = new CarRepository();

        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM rental_agreement");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                CarAgreement tempAgreement = new CarAgreement(
                        rs.getInt(1),
                        customerRepository.getSingleEntity(rs.getInt(2)),
                        rs.getInt(4),
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
        Connection con = DatabaseConnectionManager.getConnection();
        int customerID = obj.getCustomer().getID();
        int carNumber = obj.getCar().getCarNumber();
        int period = obj.getPeriod();
        int price = obj.getPrice();
        String location = obj.getLocation();
        try{
            PreparedStatement pstmt = con.prepareStatement(
                    "insert into rental_agreement " +
                            "(`customer_id`, `car_number`, `rental_period`, `total_price`, `location`)" +
                            " values(?, ?, ?, ?, ?)");
            pstmt.setInt(1, customerID);
            pstmt.setInt(2, carNumber);
            pstmt.setInt(3, period);
            pstmt.setInt(4, price);
            pstmt.setString(5, location);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Something is wrong in creation of customeragreementrepo");
        }
    }

    @Override
    public void updateEntity(int id, int value, String type){
        Connection con = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("UPDATE rental_agreement SET "+type+" = ? WHERE agreement_id = ?;");
            pstmt.setInt(1,value);
            pstmt.setInt(2, id);
            System.out.println(pstmt);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void deleteEntity(int id){
        Connection con = DatabaseConnectionManager.getConnection();

        try{
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM rental_agreement WHERE agreement_id = ?");
            pstmt.setInt(1, id);
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
