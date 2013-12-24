<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 15.12.13
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${user.name}</title>
</head>
<body>
<center>
    <img src="reg_img.jpg" alt="logo">
    <h1>Кабінет</h1>
    ${user.name}<br>
    <!--<br>
    Зіграно: ${user.gamesPlayed}
    <br>
    Виграно: ${user.gamesWon}
    <br>-->
    <br>
    <br>
    <a href="/rooms">Ігрові кімнати</a>
    </center>
</body>
</html>
