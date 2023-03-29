package flightservlet.service;

import flightservlet.dao.FlightDao;
import flightservlet.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private static final FlightService INSTANCE = new FlightService();

    private FlightService() {
    }

    public static FlightService getINSTANCE() {
        return INSTANCE;
    }

    private static final FlightDao flightDao = FlightDao.getINSTANCE();
    public List<FlightDto>  findAll() {

        return flightDao.findAll()
                .stream()
                .map(flight -> FlightDto.builder()
                        .id (flight.getId())
                        .description("""
                        %s - %s - %s
                        """.formatted(flight.getDepartureAirportCode(),
                                flight.getArrivalAirportCode(),
                                flight.getStatus())).build())
                .collect(Collectors.toList());
    }

}
