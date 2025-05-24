package com.example.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/energie", "root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
