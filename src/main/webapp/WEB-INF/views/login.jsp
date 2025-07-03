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
        <input value="marie.rabe@biblio.com" type="text" name="email" required /><br/>
        <label>Mot de passe :</label>
        <input value="adminpass" type="password" name="motDePasse" required /><br/>
        <button type="submit">Se connecter</button>
    </form>
    <c:if test="${not empty erreur}">
        <p style="color:red;">${erreur}</p>
    </c:if>
</body>
</html>
