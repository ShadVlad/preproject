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
<h4>Все пользователи</h4>
<hr />
<table border="" width="90%">
    <tr><th>Имя</th><th>Фамилия</th><th>Возраст</th>
        <th>e-mail</th><th>Логин</th><th>Роль</th><th colspan="2">Действие</th></tr>
    <c:forEach var="user" items="${requestScope.users}">
        <tr><td><c:out value="${user.name}"/></td><td><c:out value="${user.surname}"/></td>
            <th><c:out value="${user.age}"/></th><th><c:out value="${user.email}"/>
            <th><c:out value="${user.login}"/></th><th><c:out value="${user.role}"/>
            <th>
                <a href="/admin/update?id=<c:out value='${user.id}' />">изменить</a>
            </th>
            <th>
                <a href="/admin/delete?id=<c:out value='${user.id}' />">удалить</a>
            </th>
        </tr>
    </c:forEach>
</table>
<hr />
<a href="<c:url value="/logout"/>">Logout</a>
<a href="<c:url value="/admin/add"/>">Add user</a>
<a href="<c:url value="/user"/>">User info</a>
</body>
</html>
