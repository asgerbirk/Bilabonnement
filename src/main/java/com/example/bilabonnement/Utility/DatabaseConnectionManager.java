package com.example.bilabonnement.Utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnectionManager {
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    private DatabaseConnectionManager(){
    }

    public static Connection getConnection(){
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