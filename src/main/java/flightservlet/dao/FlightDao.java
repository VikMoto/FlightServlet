package flightservlet.dao;

import flightservlet.entity.Flight;
import flightservlet.entity.FlightStatus;
import flightservlet.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {

    private static final FlightDao INSTANCE = new FlightDao();
    private FlightDao() {
    }

    public static FlightDao getINSTANCE() {
        return INSTANCE;
    }

    private static final String FIND_ALL = """
           SELECT * 
           FROM flight;
            """;
    @Override
    public List<Flight> findAll() {
        List<Flight> flights = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL) ) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flights.add(buildFlight(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flights;
    }


    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Flight entity) {

    }

    @Override
    public Flight save(Flight entity) {
        return null;
    }

    private Flight buildFlight(ResultSet resultSet) throws SQLException {
        return new Flight(
            resultSet.getObject("id", Long.class),
            resultSet.getObject("flight_no", String.class),
            resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
            resultSet.getObject("departure_airport_code", String.class),
            resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
            resultSet.getObject("arrival_airport_code", String.class),
            resultSet.getObject("aircraft_id", Integer.class),
            FlightStatus.valueOf(resultSet.getObject("status", String.class))
        );


    }
}
