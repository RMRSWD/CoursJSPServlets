<%--
  Created by IntelliJ IDEA.
  User: o22002708@campus.univ-orleans.fr
  Date: 17/01/2024
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Pages Connexion</h1>
<form action="/pel/connexion" method="post">
    <jsp:useBean id="erreur" class="java.lang.String" scope="request"/>
    <c:if test="${erreur.length() > 0}">
        <span style="color: red;">
        <c:out value="${erreur}"/>
    </span>
    </c:if>

    <label>Nom d'utilisateur ou E-mail :</label>
    <input type="text" id="username" name="username" required>
<%--
    <input type="text" id="username" name="username">
--%>

    <label>Mot de passe :</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Connexion</button>

</form>
</body>
</html>
