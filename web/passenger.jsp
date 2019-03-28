<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 07.03.2019
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
        <li><a href="/flight">Полёт</a></li>
        <li><a class="active" href="/passenger">Пассажир</a></li>
        <li style="float:right"><a href="/">Главная</a></li>
    </ul>
</header>
<table id="table" class = "tablePassengers" align="center" border="1" name = 'passenger'>
    <thead>
    <caption>Таблица пассажиров</caption>
    <th>ID пассажира</th>
    <th>ID полёта</th>
    <th>Имя</th>
    <th>Фамилия</th>
    <th>Редактирование</th>
    <th>Удаление</th>
    </thead>
    <tbody>
    <c:forEach var="passenger" items="${passengers}" >
        <tr>
            <td><c:out value="${passenger.getID()}" /></td>
            <td><c:out value="${passenger.getIDFlight()}" /></td>
            <td><c:out value="${passenger.getFirstName()}" /></td>
            <td><c:out value="${passenger.getLastName()}" /></td>
            <td align="center"><a onclick="upd(${passenger.getID()})"link href="/updPassenger?idToUpd=${passenger.getID()}" class="delet">&#9998;</a></td>
            <td align="center"><a onclick="del(${passenger.getID()})"href="#" class="delet">&#128465;</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" colspan="6"><a link href="/addPassenger" class="design">Добавить пассажира</a></td>
    </tr>
    <tr>
        <td align="center" colspan="6"><a link href="/" class="design">Вернуться</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
