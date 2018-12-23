<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Добавление</title> 
</head>
<body>
<h2 align="center">Добавить рейс</h2>
<form method="post" action="newRace">
<table>
<tr><td>Самолет:</td><td><input name="plane" required></td></tr>
<tr><td>Откуда:</td><td><input name = "source" required></td></tr>
<tr><td>Куда:</td><td><input name = "destanation" required></td></tr>
<tr><td><button type="submit">OK</button></td></tr>
</table>
</form>
<a href="index.jsp">На главную</a>
</body>
</html>