<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 18.03.2020
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
    <h3>Hello <c:out value="${requestScope.user.name} "/> <c:out value="${requestScope.user.surname}"/>!</h3>
    <a href="<c:url value="/logout"/>">Logout</a>
    <a href="<c:url value="/admin"/>">All users</a>
</body>
</html>
