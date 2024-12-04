package org.example.dao;

import org.example.model.RoutePoint;
import org.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoutePointDAO {
    public void addRoutePoint(RoutePoint point) throws SQLException {
        String sql = "INSERT INTO route_points (train_id, station_name, arrival_time, departure_time) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, point.getTrainId());
            stmt.setString(2, point.getStationName());
            stmt.setString(3, point.getArrivalTime());
            stmt.setString(4, point.getDepartureTime());
            stmt.executeUpdate();
        }
    }

    public void updateRoutePoint(RoutePoint point) throws SQLException {
        String sql = "UPDATE route_points SET station_name = ?, arrival_time = ?, departure_time = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, point.getStationName());
            stmt.setString(2, point.getArrivalTime());
            stmt.setString(3, point.getDepartureTime());
            stmt.setInt(4, point.getPointId());
            stmt.executeUpdate();
        }
    }

    public void deleteRoutePoint(int pointId) throws SQLException {
        String sql = "DELETE FROM route_points WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pointId);
            stmt.executeUpdate();
        }
    }

    public List<RoutePoint> getRoutePointsByTrainId(int trainId) throws SQLException {
        List<RoutePoint> points = new ArrayList<>();
        String sql = "SELECT * FROM route_points WHERE train_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, trainId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                points.add(new RoutePoint(
                        rs.getInt("id"),
                        rs.getInt("train_id"),
                        rs.getString("station_name"),
                        rs.getString("arrival_time"),
                        rs.getString("departure_time")
                ));
            }
        }
        return points;
    }
}
