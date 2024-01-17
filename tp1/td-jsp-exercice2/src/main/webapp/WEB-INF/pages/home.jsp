<%--
  Created by IntelliJ IDEA.
  User: o22002708@campus.univ-orleans.fr
  Date: 17/01/2024
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Pages Connexion</h1>
<form action="/pel/connexion" method="post">
    <label for="username">Nom d'utilisateur ou E-mail :</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Mot de passe :</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Connexion</button>

</form>
</body>
</html>
