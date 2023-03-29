package flightservlet.service;

import flightservlet.dao.TicketDao;
import flightservlet.dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;


public class TicketService {
    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getINSTANCE();
    private TicketService() {
    }

    public static TicketService getINSTANCE() {
        return INSTANCE;
    }

    public List<TicketDto> findAllByFlightId (Long flightId) {
        return ticketDao.findAllById(flightId)
                .stream()
                .map(ticket -> TicketDto.builder()
                .id (ticket.getId())
                .flightId(ticket.getFlightId())
                .seatNo(ticket.getSeatNo())
                .build())
                .collect(Collectors.toList());
    }

}
