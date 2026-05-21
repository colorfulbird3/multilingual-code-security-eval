package com.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    public Connection connectToDatabase(String url, String username, String password) {
        Connection connection = null;
        try {
            // Laad die JDBC-stuurprogram
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Maak 'n nuwe verbinding met die verstrekke parameters
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC-stuurprogram kan nie laai word nie.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Verbindingsfout: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return connection;
    }
}