package jdbc.repositories;

import model.RoutePoint;
import model.TrainRoute;

import java.sql.SQLException;

public interface TrainRouteRepository {

    TrainRoute findRouteByNumber(String trainNumber);

    void addIntermediatePoint(RoutePoint point) throws SQLException;

    void removeIntermediatePoint(String trainNumber, RoutePoint point);

    void updateIntermediatePoint(String trainNumber, int index, RoutePoint newPoint);


}
