<%--
  Created by IntelliJ IDEA.
  User: o22002708@campus.univ-orleans.fr
  Date: 17/01/2024
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <jsp:useBean id="utilisateur" type="modele.Utilisateur" scope="session"/>
</head>
<body>
<h1>Menu:</h1>

<b>${utilisateur.login}</b>
<ul>
        <li>
           <a href="/pel/parisouverts">Afficher les matchs sur les quels parier</a>
        </li>

    <li>
        <a href="/pel/affichermesparis">Afficher les paris</a>
    </li>
    <li>
        <a href="/pel/deconnexion">Déconnexion</a>
    </li>
</ul>
</body>
</html>
