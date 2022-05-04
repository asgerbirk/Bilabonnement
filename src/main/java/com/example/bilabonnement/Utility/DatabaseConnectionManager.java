package com.example.bilabonnement.Utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnectionManager {
    
    private DatabaseConnectionManager(){
    }

    public static Connection getConnection(){
        String url;
        String username;
        String password;
        Connection conn = null;

        if(conn != null){
            return conn;
        }
        try{
            url = System.getenv("db.url");
            username = System.getenv("db.username");
            password = System.getenv("db.password");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("db connected");
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("fejl i db con");
        }
        return conn;
    }
}