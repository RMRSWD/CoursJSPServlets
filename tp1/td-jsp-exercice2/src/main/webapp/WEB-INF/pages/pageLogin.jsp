<%--
  Created by IntelliJ IDEA.
  User: ducvt
  Date: 12/01/2024
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page Login</title>
</head>
<body>
<form action="/login" method="post">
    <label for="username">Nom d'utilisateur ou E-mail :</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Mot de passe :</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Connexion</button>
</form>

</body>
</html>
