package org.example.dao;

import org.example.model.Train;
import org.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainDAO {
    public void addTrain(Train train) throws SQLException {
        String sql = "INSERT INTO trains (train_number, route_name) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, train.getTrainNumber());
            stmt.setString(2, train.getRouteName());
            stmt.executeUpdate();
        }
    }

    public Train getTrainByNumber(String trainNumber) throws SQLException {
        String sql = "SELECT * FROM trains WHERE train_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trainNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Train(rs.getInt("id"), rs.getString("train_number"), rs.getString("route_name"));
            }
        }
        return null;
    }

    public List<Train> getAllTrains() throws SQLException {
        List<Train> trains = new ArrayList<>();
        String sql = "SELECT * FROM trains";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                trains.add(new Train(rs.getInt("id"), rs.getString("train_number"), rs.getString("route_name")));
            }
        }
        return trains;
    }

    public void deleteTrain(int trainId) throws SQLException {
        String sql = "DELETE FROM trains WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, trainId);
            stmt.executeUpdate();
        }
    }
}
