<%@page import="by.example.air.beans.Race"%>
<%@page import="by.example.air.dao.RaceDAO"%>
<%@page import="by.example.air.beans.Ticket"%>
<%@page import="java.util.List"%>
<%@page import="by.example.air.dao.TicketsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Билеты</title>
</head>
<body>
<h2 align="center">Список билетов</h2>

<%
TicketsDAO ticketsDAO = new TicketsDAO();
RaceDAO raceDAO = new RaceDAO();
List<Ticket> list = ticketsDAO.getTickets();
out.println("<table border=\"3\"><tr><td>Имя</td><td>Фамилия</td><td>Стоимость</td>"+
"<td>Дата</td><td>Отправлене</td><td>Прибытие</td><td>Самолет</td></tr>");
for(Ticket ticket:list){
	out.println("<tr><td>"+ticket.getName()+"</td>");
	out.println("<td>"+ticket.getLastname()+"</td>");
	out.println("<td>"+ticket.getCost()+"</td>");
	out.println("<td>"+ticket.getDate()+"</td>");
	Race race = raceDAO.getRace(ticket.getId());
	out.println("<td>"+race.getSource()+"</td>");
	out.println("<td>"+race.getDestanation()+"</td>");
	out.println("<td>"+race.getPlane()+"</td></tr>");
}
out.println("</table>");
 %>
<a href = "register.jsp">Регистрация  </a>&nbsp<a href = "add_race.jsp">Добавить рейс</a>
<br>
<a href="index.jsp">На главную</a>
</body>
</html>