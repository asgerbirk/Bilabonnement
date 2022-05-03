package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Car;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository  implements CRUD<Car>{
    @Override
    public List<Car> getAllEntities() {
        Connection connection = DatabaseConnectionManager.getConnection();
        List<Car> allCars = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bil");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Car temporyCar = new Car(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBoolean(6)
                );

                allCars.add(temporyCar);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("something went wrong with the database");
        }
        System.out.println(allCars);
        return allCars;
    }
}
