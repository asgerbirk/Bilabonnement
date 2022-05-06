package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DamageReportRepository implements CRUD<DamageReport>{


    @Override
    public List<DamageReport> getAllEntities() {
        return null;
    }

    @Override
    public Object getSingleEntity(int T) {
        return null;
    }

    @Override
    public void createEntity(DamageReport damageReport) {
        Connection connection = DatabaseConnectionManager.getConnection();
        String damage = damageReport.getDamage();
        int price = damageReport.getPrice();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO damage_report (`damage`, `price`) VALUES (?,?)");
            stmt.setString(1,damage);
            stmt.setInt(2,price);
            stmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
