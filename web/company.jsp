<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 06.03.2019
  Time: 23:05
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
        <li><a class="active" href="/company">Компания</a></li>
        <li><a href="/direction">Направление</a></li>
        <li><a href="/flight">Полёт</a></li>
        <li><a href="/passenger">Пассажир</a></li>
        <li style="float:right"><a href="/">Главная</a></li>
    </ul>
</header>
<table id="table" class = "tableCompanies" align="center" border="1" name = 'company'>
    <thead>
    <caption>Таблица компаний</caption>
    <th>ID компании</th>
    <th>Название компании</th>
    <th>Редактирование</th>
    <th>Удаление</th>
    </thead>
    <tbody>
    <c:forEach var="company" items="${companies}" >
        <tr>
            <td><c:out value="${company.getID()}" /></td>
            <td><c:out value="${company.getName()}" /></td>
            <td align="center"><a onclick="upd(${company.getID()})"link href="/updCompany?idToUpd=${company.getID()}" class="delet">&#9998;</a></td>
            <td align="center"><a onclick="del(${company.getID()})"href="#" class="delet">&#128465;</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" colspan="4"><a link href="/addCompany" class="design">Добавить компанию</a></td>
    </tr>
    <tr>
        <td align="center" colspan="4"><a link href="/" class="design">Вернуться</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
