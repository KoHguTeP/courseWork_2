<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 07.03.2019
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Таблица полётов</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/stylesCompany.css"/>
    <script src="tables.js"></script>
</head>
<body>
<header>
    <ul>
        <li><a href="/airplane">Самолёт</a></li>
        <li><a href="/company">Компания</a></li>
        <li><a href="/direction">Направление</a></li>
        <li><a class="active" href="/flight">Полёт</a></li>
        <li><a href="/passenger">Пассажир</a></li>
        <li style="float:right"><a href="/">Главная</a></li>
    </ul>
</header>
<table id="table" class = "tableFlights" align="center" border="1" name = 'flight'>
    <thead>
    <caption><c:out value='Таблица полётов'></c:out></caption>
    <th>ID полёта</th>
    <th>Название самолёта</th>
    <th>Направление откуда</th>
    <th>Направление куда</th>
    <th>Время прилёта</th>
    <th>Время вылета</th>
    <th>Дата прилёта</th>
    <th>Дата вылета</th>
    <th>Стоимость</th>
    <th>Редактирование</th>
    <th>Удаление</th>
    </thead>
    <tbody>
    <c:forEach var="flight" items="${flights}" >
        <tr>
            <td><c:out value="${flight.getIDFlight()}" /></td>
            <td><c:out value="${flightDAO.getNameAirplane(flight)}" /></td>
            <td><c:out value="${flightDAO.getDirectionFrom(flight)}" /></td>
            <td><c:out value="${flightDAO.getDirectionTo(flight)}" /></td>
            <td><c:out value="${flight.getTimeArrival()}" /></td>
            <td><c:out value="${flight.getTimeDeparture()}" /></td>
            <td><c:out value="${flight.getDateArrival()}" /></td>
            <td><c:out value="${flight.getDateDeparture()}" /></td>
            <td><c:out value="${flight.getCost()}" /></td>
            <td align="center"><a onclick="upd(${flight.getIDFlight()})"link href="/updFlight?idToUpd=${flight.getIDFlight()}" class="delet">&#9998;</a></td>
            <td align="center"><a onclick="del(${flight.getIDFlight()})"href="#" class="delet">&#128465;</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" colspan="11"><a link href="/addFlight" class="design">Добавить полёт</a></td>
    </tr>
    <tr>
        <td align="center" colspan="11"><a link href="/" class="design">Вернуться</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
