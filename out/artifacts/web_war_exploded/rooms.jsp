<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 23.12.13
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Rooms</title>
    <script>
        function redirect()
        {
            window.location = "/addroom";
        }
        function game()
        {
            window.location = "/game";
        }
        function join(room)
        {
            window.location = "/joinroom?roomOwner=" + room;
        }
        function start(room)
        {
            window.location = "/startroom?roomOwner=" + room;
        }
    </script>
</head>
<body>

<script type="text/javascript">
    var timeout = setTimeout("location.reload(true);",2000);
    function resetTimeout() {
        clearTimeout(timeout);
        timeout = setTimeout("location.reload(true);",2000);
    }
</script>
<a href="/lk.jsp">Кабінет</a>
<center>
<img src="login_img.jpg" alt="logo">
<h1>Ігрові кімнати</h1>
</center>
<table width="100%">
    <tr>
        <td width="50%">
            Кімнати:
            <table border="1">
                <c:forEach var="room" items="${rooms}">
                    <tr>
                        <td><c:out value="${room.owner}" /></td>
                        <td><c:out value="${room.user2}" /></td>
                        <td>
                            <c:if test="${empty room.user2}">
                                <button type="button" onclick="join(<c:out value="\"${room.owner}\"" />)">Приєднатися</button>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>


        <td width="50%">
            Моя кімната:
            <c:if test="${not empty ownedRoom}">
                <table border="1">
                    <tr><td>${ownedRoom.owner}</td><td>${ownedRoom.user2}</td>
                        <td>
                            <c:if test="${not empty ownedRoom.user2}">
                                <button type="button" onclick="start(<c:out value="\"${ownedRoom.owner}\"" />)">Старт</button>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </c:if>

            <c:if test="${empty ownedRoom}">
            <button type="button" onclick="redirect()">Створити</button>
            </c:if>
        </td>
    </tr>
</table>


</table>

</body>
</html>
