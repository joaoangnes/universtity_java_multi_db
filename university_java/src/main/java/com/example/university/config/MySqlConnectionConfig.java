package com.example.university.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class to create the MySQL connection with a Singleton design pattern
public class MySqlConnectionConfig {
    private static final String JDBC_URL = ConfigLoader.getMySQLUrl();
    private static final String DB_USER = ConfigLoader.getMySQLUser();
    private static final String DB_PASSWORD = ConfigLoader.getMySQLPassword();

    // Instância MySQL (Singleton)
    private static MySqlConnectionConfig instance;
    private Connection connection;

    private MySqlConnectionConfig() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the MySQL JDBC server
            connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            System.out.println("MySQL connection successfully established.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("MySQL connection failed: " + e.getMessage());
        }
    }

    public static MySqlConnectionConfig getInstance() {
        if (instance == null) {
            synchronized (MySqlConnectionConfig.class) {
                if (instance == null) {
                    instance = new MySqlConnectionConfig();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("MySQL connection closed successfully.");
        } catch (SQLException e) {
            System.out.println("[ERROR] - Failed to close connection to MySQL: " + e.getMessage());
        }
    }
}
