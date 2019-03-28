<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 06.03.2019
  Time: 23:56
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
        <li><a class="active" href="/direction">Направление</a></li>
        <li><a href="/flight">Полёт</a></li>
        <li><a href="/passenger">Пассажир</a></li>
        <li style="float:right"><a href="/">Главная</a></li>
    </ul>
</header>
<table id="table" class = "tableDirections" align="center" border="1" name = 'direction'>
    <thead>
    <caption>Таблица направлений</caption>
    <th>ID направления</th>
    <th>Откуда</th>
    <th>Куда</th>
    <th>Редактирование</th>
    <th>Удаление</th>
    </thead>
    <tbody>
    <c:forEach var="direction" items="${directions}" >
        <tr>
            <td><c:out value="${direction.getID()}" /></td>
            <td><c:out value="${direction.getFrom()}" /></td>
            <td><c:out value="${direction.getTo()}" /></td>
            <td align="center"><a onclick="upd(${direction.getID()})"link href="/updDirection?idToUpd=${direction.getID()}" class="delet">&#9998;</a></td>
            <td align="center"><a onclick="del(${direction.getID()})"href="#" class="delet">&#128465;</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" colspan="5"><a link href="/addDirection" class="design">Добавить направление</a></td>
    </tr>
    <tr>
        <td align="center" colspan="5"><a link href="/" class="design">Вернуться</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
