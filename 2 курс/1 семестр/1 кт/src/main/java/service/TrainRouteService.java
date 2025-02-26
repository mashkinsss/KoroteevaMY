package service;

import model.RoutePoint;
import model.TrainRoute;

import java.util.ArrayList;
import java.util.List;

// Сервисный класс для управления маршрутами поездов
public class TrainRouteService {
    private List<TrainRoute> routes;

    public TrainRouteService() {
        this.routes = new ArrayList<>();
    }

    public void addRoute(TrainRoute route) {
        routes.add(route);
    }

    public void removeRoute(TrainRoute route) {
        routes.remove(route);
    }

    public TrainRoute findRouteByNumber(String trainNumber) {
        return routes.stream()
                .filter(route -> route.getTrainNumber().equals(trainNumber))
                .findFirst()
                .orElse(null);
    }

    public void addIntermediatePoint(String trainNumber, RoutePoint point) {
        TrainRoute route = findRouteByNumber(trainNumber);
        if (route != null) {
            route.addIntermediatePoint(point);
        }
    }

    public void removeIntermediatePoint(String trainNumber, RoutePoint point) {
        TrainRoute route = findRouteByNumber(trainNumber);
        if (route != null) {
            route.removeIntermediatePoint(point);
        }
    }

    public void updateIntermediatePoint(String trainNumber, int index, RoutePoint newPoint) {
        TrainRoute route = findRouteByNumber(trainNumber);
        if (route != null) {
            route.updateIntermediatePoint(index, newPoint);
        }
    }

    public List<TrainRoute> getRoutes() {
        return routes;
    }
}