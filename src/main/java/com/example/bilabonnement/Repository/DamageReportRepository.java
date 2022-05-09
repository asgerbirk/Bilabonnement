package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DamageReportRepository implements CRUD<DamageReport>{


    @Override
    public List<DamageReport> getAllEntities() {
        Connection connection = DatabaseConnectionManager.getConnection();
        List<DamageReport> allReports = new ArrayList<>();
        DamageReportRepository damageRepo = new DamageReportRepository();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM damage_report");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DamageReport tempReport = new DamageReport(
                        rs.getInt("id"),
                        rs.getString("damage"),
                        rs.getInt("price")
                );
                allReports.add(tempReport);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return allReports;
    }

    @Override
    public DamageReport getSingleEntity(int reportID) {
        List<DamageReport> allReports = getAllEntities();
        DamageReport tempReport = null;
        for (DamageReport rep: allReports) {
            if(rep.getId() == reportID){
                tempReport = rep;
            }
        }
        return tempReport;
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

    @Override
    public void updateEntity(int id, int value){
        Connection connection = DatabaseConnectionManager.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement("UPDATE damage_report SET price=? WHERE damage_report_id=?");
            pstmt.setInt(1,value);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
