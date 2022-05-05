package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.util.List;

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

    }


}
