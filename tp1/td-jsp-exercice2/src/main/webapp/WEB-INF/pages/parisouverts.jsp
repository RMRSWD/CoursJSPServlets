<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: o22002708@campus.univ-orleans.fr
  Date: 17/01/2024
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Liste des paris ouverts</title>
    <jsp:useBean id="utilisateur" type="modele.Utilisateur" scope="session"/>
    <jsp:useBean id="parisOuverts" type="java.util.Collection" scope="session"/>
</head>
<body>
<p>Bonjour ${utilisateur.login}</p>
<ul>
    <c:forEach items="${parisOuverts}" var="match">
        <li>
            match: ${match.sport} - ${match.equipe1} vs ${match.equipe2}
        </li>

    </c:forEach>
</ul>
</body>
</html>
