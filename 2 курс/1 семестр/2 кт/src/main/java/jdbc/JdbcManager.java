package jdbc;

import jdbc.repositories.TrainRouteRepository;
import jdbc.utils.ConnectionManager;
import model.RoutePoint;
import model.TrainRoute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JdbcManager implements TrainRouteRepository {

    public JdbcManager() {
    }

    public void connection() throws SQLException {

        String sql = """
                CREATE TABLE route_point (
                    id serial primary key,
                    station_name varchar(256),
                    arrival_time varchar(256),
                    departure_time varchar(256)
);
                """;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {

            System.out.println(statement.execute(sql));

            connection.getTransactionIsolation();
        }
    }

    @Override
    public TrainRoute findRouteByNumber(String trainNumber) {
        return null;
    }

    @Override
    public void addIntermediatePoint(RoutePoint point) throws SQLException{
        String stationName = point.getStationName();
        LocalTime arrivalTime = point.getArrivalTime();
        LocalTime departureTime = point.getDepartureTime();


        String sql = """
                insert into route_point(station_name, arrival_time, departure_time)
                values (?, ?, ?)
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, stationName);
            statement.setString(2, arrivalTime.toString());
            statement.setString(3, departureTime.toString());

            System.out.println(statement.execute());


            connection.getTransactionIsolation();
        }
    }

    @Override
    public void removeIntermediatePoint(String trainNumber, RoutePoint point) {

    }

    @Override
    public void updateIntermediatePoint(String trainNumber, int index, RoutePoint newPoint) {

    }
}
