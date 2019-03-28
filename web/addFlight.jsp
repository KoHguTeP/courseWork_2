<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 07.03.2019
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление полёта</title>
    <link rel="stylesheet" href="css/stylesDirection.css"/>
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
<div class="menu">
</div>
<div class="description">
    <form action="addFlight" method="post">
        <table class = "tableFlights" align="center" border="1">
            <thead>
            <caption><c:out value="Добавление полёта"></c:out></caption></thead>
            <tbody>
            <tr>
                <td>ID полёта</td>
                <td><input name="ID_flight" type="number" placeholder="0" class="textbox"></td>
            </tr>
            <tr>
                <td>ID самолёта</td>
                <td>
                    <select name="ID_airplane">
                        <c:forEach var="airplane" items="${airplanes}">
                            <option label=${airplane.getName()} value=${airplane.getID()}>${airplane.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Направление</td>
                <td>
                    <select name="ID_direction">
                        <c:forEach var="direction" items="${directions}">
                            <option label='${direction.getFrom()} - ${direction.getTo()}' value=${direction.getID()}>${direction.getFrom()} - ${direction.getTo()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Дата вылета</td>
                <td>
                    <input type="date" name="date_arrival"
                           value = new Date();
                           min="2019-01-01" max="2019-12-31">
                </td>
            </tr>
            <tr>
                <td>Время вылета</td>
                <td><input name="time_arrival" type="text" placeholder="0" class="textbox"></td>
            </tr>
            <tr>
                <td>Дата прилёта</td>
                <td>
                    <input type="date" name="date_departure"
                           value = new Date();
                           min="2019-01-01" max="2019-12-31">
                </td>
            </tr>
            <tr>
                <td>Время прилёта</td>
                <td><input name="time_departure" type="text" placeholder="0" class="textbox"></td>
            </tr>
            <tr>
                <td>Стоимость</td>
                <td><input name="cost" type="number" placeholder="0" class="textbox"></td>
            </tr>
            <tr>
                <td align="center" colspan="8"><button input type="submit" class="design">Добавить</button></td>
            </tr>
            <tr>
                <td align="center" colspan="8"><a href="/flight" class="design">Отмена</a></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
