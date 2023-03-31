<%--
  Created by IntelliJ IDEA.
  User: adifi
  Date: 28.03.2023
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="flightservlet.service.TicketService" %>
<%@ page import="flightservlet.dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="" %>--%>
<%--<%@ include file="index.html" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Hare Krishna</h1>
<h1>List of flights </h1>
<ul>
    <%
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        TicketService ticketService = TicketService.getINSTANCE();
        List<TicketDto> tickets = ticketService.findAllByFlightId(flightId);
        for (TicketDto ticket : tickets) {
            out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
        }

    %>
</ul>
</body>
</html>

<%!
    public void jspInit() {
        System.out.println("true Hello world");
    }
%>
