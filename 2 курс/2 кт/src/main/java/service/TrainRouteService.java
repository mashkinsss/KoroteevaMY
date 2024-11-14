package service;

import jdbc.JdbcManager;
import jdbc.repositories.TrainRouteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import model.RoutePoint;
import model.TrainRoute;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
// Сервисный класс для управления маршрутами поездов
public class TrainRouteService {

    private JdbcManager jdbcManager = new JdbcManager();


    private List<TrainRoute> routes = new ArrayList<>();


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

    public void addIntermediatePoint(String trainNumber, RoutePoint point) throws SQLException {
            jdbcManager.addIntermediatePoint(point);

    }

    public void removeIntermediatePoint(String trainNumber, RoutePoint point) {
        TrainRoute route = findRouteByNumber(trainNumber);
        if (route != null) {
            //route.removeIntermediatePoint(point);
        }
    }

    public void updateIntermediatePoint(String trainNumber, int index, RoutePoint newPoint) {
        TrainRoute route = findRouteByNumber(trainNumber);
        if (route != null) {
           // route.updateIntermediatePoint(index, newPoint);
        }
    }

    public List<TrainRoute> getRoutes() {
        return routes;
    }
}