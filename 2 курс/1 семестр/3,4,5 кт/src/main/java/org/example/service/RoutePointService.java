package org.example.service;

import org.example.dao.RoutePointDAO;
import org.example.model.RoutePoint;

import java.sql.SQLException;
import java.util.List;

public class RoutePointService {
    private final RoutePointDAO routePointDAO;

    public RoutePointService() {
        this.routePointDAO = new RoutePointDAO();
    }

    public void addRoutePoint(RoutePoint point) throws SQLException {
        routePointDAO.addRoutePoint(point);
    }

    public void updateRoutePoint(RoutePoint point) throws SQLException {
        routePointDAO.updateRoutePoint(point);
    }

    public void deleteRoutePoint(int pointId) throws SQLException {
        routePointDAO.deleteRoutePoint(pointId);
    }

    public List<RoutePoint> getRoutePointsByTrainId(int trainId) throws SQLException {
        return routePointDAO.getRoutePointsByTrainId(trainId);
    }
}
