<%--
  Created by IntelliJ IDEA.
  User: tplocal
  Date: 18/01/2024
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <jsp:useBean id="utilisateur" type="modele.Utilisateur" scope="session"/>
    <jsp:useBean id="mesparis" type="java.util.Collection<modele.Pari>" scope="session"/>
</head>
<body>
<ul>
<c:forEach items="${mesparis}" var = "paris">
    <li>
        sport: ${paris.match.sport} - ${paris.match.equipe1} vs ${paris.match.equipe2} ${paris.match.quand}. Mise de ${paris.montant} sur ${paris.vainqueur}
        <a href="/pel/confirmationAnnulerPari?id=${paris.idPari}"><a href="/pel/annuler">Annuler</a></a>

    </li>

</c:forEach>
</ul>
</body>
</html>
