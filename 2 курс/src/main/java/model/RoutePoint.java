package model;

import java.time.LocalTime;
import java.util.UUID;

// Класс, представляющий пункт маршрута
public class RoutePoint {
    private String id;
    private String stationName;
    private LocalTime arrivalTime;
    private LocalTime departureTime;

    public RoutePoint(String stationName, LocalTime arrivalTime, LocalTime departureTime) {
        this.id = UUID.randomUUID().toString();  // Уникальный идентификатор
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getId() {
        return id;
    }

    public String getStationName() {
        return stationName;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    @Override
    public String toString() {
        return stationName + " (Прибытие: " + arrivalTime + ", Отправление: " + departureTime + ")";
    }
}