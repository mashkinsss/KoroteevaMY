package org.example.service;

import org.example.dao.TrainDAO;
import org.example.model.Train;

import java.sql.SQLException;
import java.util.List;

public class TrainService {
    private final TrainDAO trainDAO;

    public TrainService() {
        trainDAO = new TrainDAO();
    }

    public void addTrain(Train train) throws SQLException {
        trainDAO.addTrain(train);
    }

    public Train getTrainByNumber(String trainNumber) throws SQLException {
        return trainDAO.getTrainByNumber(trainNumber);
    }

    public List<Train> getAllTrains() throws SQLException {
        return trainDAO.getAllTrains();
    }

    public void deleteTrain(int trainId) throws SQLException {
        trainDAO.deleteTrain(trainId);
    }
}
