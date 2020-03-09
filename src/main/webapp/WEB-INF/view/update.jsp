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
<h4>Редактирование пользователя</h4>
<form method="post" action="<c:url value='/update'/>">
    <label>Имя:</label><br>
    <input type="text" name="name" value="${requestScope.user.name}" /><br><br>
    <label>Фамилия:</label><br>
    <input type="text" name="surname" value="${requestScope.user.surname}" /><br><br>
    <label>Возраст:</label><br>
    <input type="number" name="age" value="${requestScope.user.age}" /><br><br>
    <label>E-mail :</label><br>
    <input type="text" name="email" value="${requestScope.user.email}" /><br><br>

    <input type="number" hidden name="id" value="${requestScope.user.id}"/>

    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>
