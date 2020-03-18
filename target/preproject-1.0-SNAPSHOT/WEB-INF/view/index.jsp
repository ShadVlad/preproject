<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 03.03.2020
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Использование mySQL</title>

</head>
<body>

<h4>Создание нового пользователя</h4>
<hr />
<form method="post" action="<c:url value='/add'/>">

    Имя      <label><input type="text" name="name"></label>
    Фамилия  <label><input type="text" name="surname"></label>
    Возраст  <label><input type="number" name="age"></label>
    e-mail   <label><input type="text" name="email"></label>
    <br><br>
    login    <label><input type="text" name="login"></label>
    password <label><input type="text" name="password"></label>
    role     <label><input type="text" name="role"></label>
    <input type="submit" value="Создать" name="Ok"><br>
</form>

<br>
<h4>Все пользователи</h4>
<hr />
<table border="" width="90%">
    <tr><th>Имя</th><th>Фамилия</th><th>Возраст</th>
        <th>e-mail</th><th colspan="2">Действие</th></tr>
    <c:forEach var="user" items="${requestScope.users}">
        <tr><td><c:out value="${user.name}"/></td><td><c:out value="${user.surname}"/></td>
            <th><c:out value="${user.age}"/></th><th><c:out value="${user.email}"/>
            <th>
                <a href="update?id=<c:out value='${user.id}' />">изменить</a>
            </th>
            <th>
                <a href="delete?id=<c:out value='${user.id}' />">удалить</a>
            </th>
        </tr>
    </c:forEach>
</table>
<hr />
<a href="<c:url value="/logout"/>">Logout</a>

</body>
</html>
