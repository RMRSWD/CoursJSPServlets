<%--
  Created by IntelliJ IDEA.
  User: dv
  Date: 24/01/2024
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Annuler le pari</title>
    <jsp:useBean id="mesParis" type="java.util.Collection<modele.Pari>" scope="session"/>
    <jsp:useBean id="idParis" type="modele.Pari" scope="session"/>
</head>
<body>
<c:forEach var="parismoi" items="${mesParis}">
    <c:if test="${parismoi.idPari eq idParis}">
        <p> Vous avez bien annuler le match ${parismoi.match.sport} - ${parismoi.match.equipe1} vs ${parismoi.match.equipe1} à ${parismoi.match.quand}</p>
    </c:if>
</c:forEach>
<a href="/pel/home">Retourner</a>
</body>
</html>
