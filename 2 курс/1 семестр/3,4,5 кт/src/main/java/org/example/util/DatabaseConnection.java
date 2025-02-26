package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String BASE_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "train_route_db";
    private static final String FULL_URL = BASE_URL + DB_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "qwerty";

    static {
        initializeDatabase();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(FULL_URL, USER, PASSWORD);
    }

    private static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(BASE_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);

            try (Connection dbConnection = DriverManager.getConnection(FULL_URL, USER, PASSWORD);
                 Statement dbStatement = dbConnection.createStatement()) {

                dbStatement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS trains (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        train_number VARCHAR(20) NOT NULL,
                        route_name VARCHAR(100) NOT NULL
                    )
                """);

                dbStatement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS route_points (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        train_id INT NOT NULL,
                        station_name VARCHAR(100) NOT NULL,
                        arrival_time TIME NOT NULL,
                        departure_time TIME NOT NULL,
                        FOREIGN KEY (train_id) REFERENCES trains(id) ON DELETE CASCADE
                    )
                """);

                System.out.println("Database and tables initialized successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
