package flightservlet.servlets;

import flightservlet.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(value = "/tickets")
public class TicketServlet extends HttpServlet {
    private final TicketService ticketService = TicketService.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long flightId = Long.valueOf(req.getParameter("flightId"));
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter respWriter = resp.getWriter()) {
            respWriter.write("<h1>Sold tickets:</h1>");
            respWriter.write("<ul>");
            ticketService.findAllByFlightId(flightId).forEach(
                    ticketDto -> respWriter.write("""
                            <li>
                            %s
                            </li>
                            """.formatted(ticketDto.getSeatNo()))
            );

            respWriter.write("</ul>");

        }


    }
}
