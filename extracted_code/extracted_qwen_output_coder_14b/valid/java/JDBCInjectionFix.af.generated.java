package com.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    static {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Failed to load database driver: " + e.getMessage());
        }
    }

    /**
     * Establishes a database connection using the provided connection parameters
     *
     * @param url      Database connection URL
     * @param username Database username
     * @param password Database password
     * @return Database connection object
     * @throws SQLException if connecting to the database fails
     */
    public Connection connectToDatabase(String url, String username, String password) throws SQLException {
        if (url == null || username == null || password == null) {
            throw new IllegalArgumentException("Connection parameters cannot be null");
        }
        return DriverManager.getConnection(url, username, password);
    }
}