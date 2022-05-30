package com.example.bilabonnement.Utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnectionManager {
    // Kodet af Asger
    
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
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}