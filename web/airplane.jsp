<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 05.03.2019
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Таблица самолётов</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/stylesCompany.css"/>
    <script src="tables.js"></script>
</head>
<body>
<header>
    <ul>
        <li><a class="active" href="/airplane">Самолёт</a></li>
        <li><a href="/company">Компания</a></li>
        <li><a href="/direction">Направление</a></li>
        <li><a href="/flight">Полёт</a></li>
        <li><a href="/passenger">Пассажир</a></li>
        <li style="float:right"><a href="/">Главная</a></li>
    </ul>
</header>
<table id="table" class = "tableAirplanes" align="center" border="1" name = 'airplane'>
    <thead>
    <caption><c:out value='Таблица самолётов'></c:out></caption>
    <th>ID</th>
    <th>Название самолёта</th>
    <th>Название компании</th>
    <th>Редактирование</th>
    <th>Удаление</th>
    </thead>
    <tbody>
    <c:forEach var="airplane" items="${airs}" >
        <tr>
            <td><c:out value="${airplane.getID()}" /></td>
            <td><c:out value="${airplane.getName()}" /></td>
            <td><c:out value="${airDAO.getNameCompany(airplane)}"/></td>
            <td align="center"><a onclick="upd(${airplane.getID()})"link href="/updAirplane?idToUpd=${airplane.getID()}" class="delet">&#9998;</a></td>
            <td align="center"><a onclick="del(${airplane.getID()})"href="#" class="delet">&#128465;</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" colspan="5"><a link href="/addAirplane" class="design">Добавить самолёт</a></td>
    </tr>
    <tr>
        <td align="center" colspan="5"><a link href="/" class="design">Вернуться</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
