package org.example.model;

public class RoutePoint {
    private int pointId;
    private int trainId;
    private String stationName;
    private String arrivalTime;
    private String departureTime;

    public RoutePoint(int pointId, int trainId, String stationName, String arrivalTime, String departureTime) {
        this.pointId = pointId;
        this.trainId = trainId;
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "RoutePoint {ID=" + pointId + ", TrainID=" + trainId +
                ", Station='" + stationName + "', Arrival='" + arrivalTime +
                "', Departure='" + departureTime + "'}";
    }
}
