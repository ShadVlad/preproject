<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 27.03.2020
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>New user</title>
</head>
<body>
<h4>Создание нового пользователя</h4>
<hr />
<form method="post" action="<c:url value='/admin/add'/>">

    Имя      <label><input type="text" name="name"></label>
    Фамилия  <label><input type="text" name="surname"></label>
    Возраст  <label><input type="number" name="age"></label>
    e-mail   <label><input type="text" name="email"></label>
    <br><br>
    login    <label><input type="text" name="login"></label>
    password <label><input type="text" name="password"></label>
    role     <label><input type="text" name="role"></label>
    <input type="submit" value="Создать" name="Ok"><br>
    <p>${message}</p>
</form>

<br>
</body>
</html>
