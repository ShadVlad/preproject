<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 03.03.2020
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--
<body>


<div>Имя: <c:out value="${requestScope.user.name}"/> </div>
<div>Возраст: <c:out value="${requestScope.user.age}"/> </div>

<br />
/--%>
<h4>Создание нового пользователя</h4><br>
<form method="post" action="<c:url value='/update'/>">
    <label>Новое имя: <input type="text" name="name" value="${requestScope.user.name}" /></label><br>
    <label>Новая фамилия: <input type="text" name="surname" value="${requestScope.user.surname}" /></label><br>
    <label>Новый возраст: <input type="number" name="age" value="${requestScope.user.age}" /></label><br>
    <label>Новый e-mail : <input type="text" name="email" value="${requestScope.user.email}" /></label><br>

    <input type="number" hidden name="id" value="${requestScope.user.id}"/>

    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
