<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
    <h2>Page de connexion</h2>
    <form method="post" action="/login">
        <label>Email :</label>
        <input type="text" value="rakoto.jean@mail.com" name="email" required /><br/>
        <label>Mot de passe :</label>
        <input type="password" value="mdp123" name="motDePasse" required /><br/>
        <button type="submit">Se connecter</button>
    </form>
    <c:if test="${not empty erreur}">
        <p style="color:red;">${erreur}</p>
    </c:if>
</body>
</html>
