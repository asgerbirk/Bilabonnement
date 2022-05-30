package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository  implements CRUD<Car> {
    // Kodet af Simon
    @Override
    public List<Car> getAllEntities() {
        Connection con = DatabaseConnectionManager.getConnection();
        List<Car> allCars = new ArrayList<>();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM car");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Car temporaryCar = new Car(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7)
                );
                allCars.add(temporaryCar);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("something went wrong with the database for cars");
        }
        System.out.println(allCars);
        return allCars;
    }

    @Override
    public Car getSingleEntity(int carNumber) {
        List<Car> allCars = getAllEntities();
        Car tempCar = null;
        for (Car c : allCars) {
            if(c.getCarNumber()==carNumber){
                tempCar = c;
            }
        }
        return tempCar;
    }

    @Override
    public void createEntity(Car T) {
        Connection con = DatabaseConnectionManager.getConnection();
        String model = T.getModel();
        String brand = T.getBrand();
        String color = T.getColor();
        int price = T.getPrice();
        boolean isDamaged = T.isDamaged();
        boolean isRented = T.isRented();

        try {
            PreparedStatement pstmt = con.prepareStatement("insert into car (`model`, `brand`, `color`, `price`, `damaged`, `rented`) values("+model+", "+brand+", "+color+", "+price+", "+isDamaged+", "+isRented+")");
            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEntity(int id, int value, String type){
        Connection con = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("UPDATE car SET "+type+" = ? WHERE car_number = ?");
            pstmt.setInt(1, value);
            pstmt.setInt(2, id);
            System.out.println(pstmt);
            pstmt.executeUpdate();
            pstmt.close();

        }catch (SQLException e){
            e.printStackTrace();
        }



    }

    @Override
    public void deleteEntity(int id){
        Connection con = DatabaseConnectionManager.getConnection();

        try{
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM car WHERE car_number = ?");
            pstmt.setInt(1, id);
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
