<%--<%@ page import="flightservlet.service.TicketService" %>--%>
<%--<%@ page import="flightservlet.dto.TicketDto" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="https://google.com" %>--%>
<%--<%@ include file="index.html" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>th
    <title>Title</title>
</head>
<body>

      <h1>Hare Krishna</h1>
      <h1>List of flights </h1>
      <ul>
          <c:forEach var="ticket" items="${requestScope.tickets}">
              <li>${ticket.seatNo}</li>
          </c:forEach>
<%--        <%--%>
<%--            Long flightId = Long.valueOf(request.getParameter("flightId"));--%>
<%--            TicketService ticketService = TicketService.getINSTANCE();--%>
<%--            List<TicketDto> tickets = ticketService.findAllByFlightId(flightId);--%>
<%--            for (TicketDto ticket : tickets) {--%>
<%--                out.write(String.format("<li>%s</li>", ticket.getSeatNo()));--%>
<%--            }--%>

<%--        %>--%>
      </ul>
</body>
</html>

<%--<%!--%>
<%--    public void jspInit() {--%>
<%--        System.out.println("true Hello world");--%>
<%--    }--%>
<%--%>--%>
