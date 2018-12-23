<%@page import="java.util.List"%>
<%@page import="by.example.air.beans.Race"%>
<%@page import="by.example.air.dao.RaceDAO"%>
<%@page import="by.example.air.beans.Ticket"%>
<%@page import="by.example.air.dao.TicketsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Регистрация на рейс</title>
</head>
<body>
<h2 align="center">Регистрация на рейс</h2>
<form action="newTicket" method="post">
	<table>
		<tr>
			<td>Номер рейса</td>
			<td><input name="id" type="number" required></td>
		</tr>
		<tr>
			<td>Имя</td>
			<td><input name="name" required></td>
		</tr>
		<tr>
			<td>Фамилия</td>
			<td><input name="lastname" required></td>
		</tr>
		<tr>
			<td>Стоимость</td>
			<td><input name="cost" type="number" required></td>
		</tr>
		<tr>
			<td>Дата</td>
			<td><input name="date" type="date" required></td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit">OK</button></td>
		</tr>
	</table>
</form>
<a href="tickets.jsp"><h3>Список билетов:</h3></a>
<h3>Список рейсов:</h3>
<table>
<%
List<Race> list = new RaceDAO().getRaces();
for(Race r:list){
	out.println(r.getRow());
}
%>
</table>
<a href="index.jsp">На главную</a>
</body>
</html>