<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KoHguTeP
  Date: 05.03.2019
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main page</title>
      <link rel="stylesheet" href="css/main.css"/>
  </head>
  <body>
  <div>
  <table id="table" class = "menu" align="center">
      <thead>
      <th colspan="5">Выбор таблицы</th>
      </thead>
      <tbody>
      <tr>
          <td><a href="/airplane">Самолёт</a></td>
          <td><a href="/company">Компания</a></td>
          <td><a href="/direction">Направление</a></td>
          <td><a href="/flight">Полёт</a></td>
          <td><a href="/passenger">Пассажир</a></td>
      </tr>
      </tbody>
  </table>
  </div>
  </body>
</html>
