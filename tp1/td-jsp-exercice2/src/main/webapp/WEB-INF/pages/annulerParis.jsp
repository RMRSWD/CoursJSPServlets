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
    <jsp:useBean id="pari" type="modele.Pari" scope="request"/>
</head>
<body>
        <p> Vous avez bien annuler le match ${pari.match.sport} - ${pari.match.equipe1} vs ${pari.match.equipe2} à ${pari.match.quand} pour montant de ${pari.montant}</p>

<a href="/pel/home">Retourner</a>
</body>
</html>
