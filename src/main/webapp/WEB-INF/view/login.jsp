<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 17.03.2020
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="form">

    <h3>Вход в систему</h3><br>
    <form method="post" action="/login">
        <label >Login    </label><br>
        <input type="text" required placeholder="login" name="login"><br><br>
        <label >Password </label><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Войти">
        <p>${message}</p>
    </form>
</div>

</body>
</html>
