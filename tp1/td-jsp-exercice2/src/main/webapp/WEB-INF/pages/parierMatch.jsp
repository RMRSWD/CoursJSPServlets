<%--
  Created by IntelliJ IDEA.
  User: tplocal
  Date: 18/01/2024
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmationd du pari</title>
    <jsp:useBean id="match" type="modele.Match" scope="session"/>
    <jsp:useBean id="utilisateur" type="modele.Utilisateur" scope="session"/>
    <jsp:useBean id="pari" type="modele.Pari" scope="session"/>
</head>
<body>
<fieldset>
    <legend>Saisie du Montant et du Verdict</legend>
<form action="#" method="post">
    <!-- Champ pour le montant -->
    <label for="montant">Montant :</label>
    <input type="number" id="montant" name="montant" required>
    <br>

    <!-- Champ pour le verdict -->
    <label for="verdict">Verdict :</label>
    <select id="verdict" name="verdict" required>
        <option value="gagner">Gagner</option>
        <option value="perdre">Perdre</option>
        <option value="annuler">Annuler</option>
    </select>
    <br>

    <!-- Bouton de soumission du formulaire -->
    <input type="submit" value="Soumettre">
</form>
</fieldset>
<fieldset>
    <legend>
        <p>${utilisateur.login}</p>

    </legend>
    <p> Vous avez parié ${pari.montant} sur le resultat ${match.resultat} pour le match: ${match.equipe1} vs ${match.equipe2} le ${match.quand}</p>
    <a href="/pel/home">Retourne au menu</a>
</fieldset>


</body>
</html>
