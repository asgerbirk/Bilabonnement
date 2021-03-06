package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Car;
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
    // Kodet af Mikkel

    @Override
    public List<DamageReport> getAllEntities() {
        Connection con = DatabaseConnectionManager.getConnection();
        List<DamageReport> allReports = new ArrayList<>();
        try{
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM damage_report");
            ResultSet rs = pstmt.executeQuery();
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
    public Car createEntity(DamageReport damageReport) {
        Connection con = DatabaseConnectionManager.getConnection();
        int agreementID = damageReport.getAgreementID();
        String damage = damageReport.getDamage();
        int price = damageReport.getPrice();
        try {
            PreparedStatement pstmt = con.prepareStatement("insert into damage_report(`rental_agreement_id`, `damage`,`price`) values (?,?,?)");
            pstmt.setInt(1,agreementID);
            pstmt.setString(2,damage);
            pstmt.setInt(3,price);
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEntity(int id, int value, String type){
        Connection con = DatabaseConnectionManager.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE damage_report SET "+type+" = ? WHERE damage_report_id=?");
            pstmt.setInt(1,value);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    @Override
    public void deleteEntity(int id){
        Connection con = DatabaseConnectionManager.getConnection();

        try{
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM damage_report WHERE damage_report_id = ?");
            pstmt.setInt(1, id);
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
