<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 24.12.13
  Time: 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Game</title>
    <link rel="stylesheet" href="styleDurak.css" />
    <script>
        function card(c)
        {
            window.location = "/updgame?card=" + c;
        }
        function otboj()
        {
            window.location = "/updgame?action=removeAll";
        }
        function takeAll()
        {
            window.location = "/updgame?action=takeAll";
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

<div class="RemoveCardsFromBoard">
    <a href="/updgame?action=removeAll">Відбій</a>
</div>
<div class="PickUpCardsFromBoard">
    <a href="/updgame?action=takeAll">Забрати</a>
</div>
<div class="north">
    <c:forEach var="card" items="${user2Cards}" varStatus="theCount">
        <div class="northPart">
            <img src="36.jpg" alt="card">
        </div>
    </c:forEach>


</div>
<div class="south">
    <c:forEach var="card" items="${userCards}" varStatus="theCount">
        <div class="southPart">
        <a href="/updgame?card=<c:out value="${theCount.index}" />"><img src="<c:out value="${card.num}" />.jpg" alt="card"></a>
        </div>
    </c:forEach>

</div>
<div class="center">
    <c:forEach var="card" items="${boardCards}">
    <div class="centerPart">
        <div class="secondCard">
            <img src="<c:out value="${card.num}" />.jpg" alt="card">
        </div>
    </div>
    </c:forEach>

    <div class="centerRightPart">
        <div class="trumpCard">
            <img src="<c:out value="${trumpCard.num}" />.jpg" alt="card">
        </div>
        <div class="cardDeck">
            <img src="36.jpg" alt="card">
        </div>
    </div>
</div>

</body>
</html>
