<%--
  Created by IntelliJ IDEA.
  User: adifi
  Date: 28.03.2023
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>


<%@ page import="flightservlet.service.Ticket" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <h1>Hare Krishna</h1>
      <h1>List of flights </h1>
      <ul>
        <%
          TicketService ticketService = TicketService.getINSTANCE();
                ticketService.findAllByFlightId(flightId).forEach(
                ticketDto -> respWriter.write("""
                            <li>
                            %s
                            </li>
                            """.formatted(ticketDto.getSeatNo()))
                );

        %>
      </ul>
</body>
</html>
