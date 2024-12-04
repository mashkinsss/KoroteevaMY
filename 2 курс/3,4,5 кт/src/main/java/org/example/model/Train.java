package org.example.model;

public class Train {
    private int trainId;
    private String trainNumber;
    private String routeName;

    public Train(int trainId, String trainNumber, String routeName) {
        this.trainId = trainId;
        this.trainNumber = trainNumber;
        this.routeName = routeName;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    @Override
    public String toString() {
        return "Train {ID=" + trainId + ", Number='" + trainNumber + "', Route='" + routeName + "'}";
    }
}
