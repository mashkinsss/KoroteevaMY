package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.UUID;

// Класс, представляющий пункт маршрута
@Getter
public class RoutePoint {

    private final String id;
    @Setter
    private String stationName;
    @Setter
    private LocalTime arrivalTime;
    @Setter
    private LocalTime departureTime;

    public RoutePoint(String stationName, LocalTime arrivalTime, LocalTime departureTime) {
        this.id = UUID.randomUUID().toString();  // Уникальный идентификатор
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return stationName + " (Прибытие: " + arrivalTime + ", Отправление: " + departureTime + ")";
    }
}