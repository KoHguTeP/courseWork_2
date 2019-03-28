<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 07.03.2019
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление пассажира</title>
    <link rel="stylesheet" href="css/stylesDirection.css"/>
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
<div class="menu">
</div>
<div class="description">
    <form action="addPassenger" method="post">
        <table class = "tablePassengers" align="center" border="1">
            <thead>
            <caption><c:out value="Добавление пассажира"></c:out></caption></thead>
            <tbody>
            <tr>
                <td>ID пассажира</td>
                <td><input name="ID_passenger" type="number" placeholder="0" class="textbox"></td>
            </tr>
            <tr>
                <td>ID полёта</td>
                <td>
                    <select name="ID_flight">
                        <c:forEach var="flight" items="${flights}">
                            <option>${flight.getIDFlight()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Имя</td>
                <td><input name="firstName" type="text" placeholder="Имя" class="textbox"></td>
            </tr>
            <tr>
                <td>Фамилия</td>
                <td><input name="lastName" type="text" placeholder="Фамилия" class="textbox"></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><button input type="submit" class="design">Добавить</button></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><a href="/passenger" class="design">Вернуться</a></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
