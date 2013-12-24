<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Durak online game</title>
  </head>
  <body><center>
    <img src="login_img.jpg" alt="logo">
    <h1>Дурачок від Гриндоса</h1>
      <form action="/login" method="POST">
          Логін:  <input type="text" name="login"/><br/>
          Пароль: <input type="password" name="password"/><br/>
          <input type="submit" value="Увійти">
      </form>
      <a href="register.jsp">Реєстрація</a>

  </center>
  </body>
</html>