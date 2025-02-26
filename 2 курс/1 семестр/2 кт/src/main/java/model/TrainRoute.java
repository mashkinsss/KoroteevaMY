package model;

import lombok.Getter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Класс, представляющий маршрут поезда
@Getter
public class TrainRoute {
    private String trainNumber;
    private String routeName;
    private RoutePoint startPoint;
    private RoutePoint endPoint;
    private List<RoutePoint> intermediatePoints;

    public TrainRoute(String trainNumber, String routeName, RoutePoint startPoint, RoutePoint endPoint) {
        this.trainNumber = trainNumber;
        this.routeName = routeName;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.intermediatePoints = new ArrayList<>();
    }

    public void addIntermediatePoint(RoutePoint point) {

        intermediatePoints.add(point);

        sortIntermediatePointsByArrivalTime();
    }

    public void removeIntermediatePointById(String pointId) {
        intermediatePoints.removeIf(point -> point.getId().equals(pointId));
    }

    public void updateIntermediatePointById(String pointId, String newStationName, LocalTime newArrivalTime, LocalTime newDepartureTime) {
    for (RoutePoint point : intermediatePoints) {
        if (point.getId().equals(pointId)) {
            point.setStationName(newStationName);  // Обновляем название станции
            point.setArrivalTime(newArrivalTime);   // Обновляем время прибытия
            point.setDepartureTime(newDepartureTime); // Обновляем время отправления
            sortIntermediatePointsByArrivalTime();   // Сортируем промежуточные станции
            break;
        }
    }
}

    private void sortIntermediatePointsByArrivalTime() {
        intermediatePoints.sort(Comparator.comparing(RoutePoint::getArrivalTime));
    }

    @Override
    public String toString() {
        StringBuilder routeInfo = new StringBuilder();
        routeInfo.append("Поезд №").append(trainNumber).append(" (").append(routeName).append("):\n");
        routeInfo.append("Начальная станция: ").append(startPoint).append("\n");
        
        if (!intermediatePoints.isEmpty()) {
            routeInfo.append("Промежуточные станции:\n");
            for (RoutePoint point : intermediatePoints) {
                routeInfo.append("  ").append(point).append("\n");
            }
        } else {
            routeInfo.append("Нет промежуточных станций\n");
        }

        routeInfo.append("Конечная станция: ").append(endPoint).append("\n");
        return routeInfo.toString();
    }
}