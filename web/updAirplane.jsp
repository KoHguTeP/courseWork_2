<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 12.03.2019
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование самолёта</title>
    <link rel="stylesheet" href="css/stylesAirplane.css"/>
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
<div class="menu">
</div>
<div class="description">
    <form action="updAirplane" method="post">
        <table class = "tableAirplanes" align="center" border="1">
            <thead>
            <caption><c:out value="Редактирование самолёта"></c:out></caption></thead>
            <tbody>
            <tr>
                <td>ID</td>
                <td><input  name="ID_airplane" type="number" class="textbox" readonly value="${idToUpd}"></td>
            </tr>
            <tr>
                <td>Название</td>
                <td><input name="name" type="text" placeholder="Название" class="textbox"></td>
            </tr>
            <tr>
                <td>ID компании</td>
                <td>
                    <select name="ID_comp">
                        <c:forEach var="company" items="${companies}">
                            <option ${company.getID() == airplaneToUpd.getIDComp() ? 'selected="selected"' : ''} value=${company.getID()}>${company.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><button input type="submit" class="design">Изменить</button></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><a href="/airplane" class="design">Отмена</a></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
