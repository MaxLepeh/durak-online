<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 15.12.13
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Durak online game - Register</title>
</head>
<body><center>
    <img src="reg_img.jpg" alt="logo">
    <h1>Реєстрація</h1>
    <form action="/register" method="POST">
        Логін:  <input type="text" name="login"/><br/>
        Пароль: <input type="password" name="password"/><br/>
        <input type="submit" value="Зареєструватися та Увійти">
    </form>

</center>
</body>
</html>
