<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulaire d'emprunt</title>
    </head>
    <body>
        <h2>Formulaire d'emprunt</h2>
        <form action="${pageContext.request.contextPath}/adherent/emprunter-livre/${idExemplaire}" method="post">
            <div>
                <label for="dateDebut">Date de début du prêt :</label>
                <input type="date" id="dateDebut" name="dateDebut" required />
            </div>
            <div>
                <label for="typePret">Type de prêt :</label>
                <select id="typePret" name="typePret" required>
                    <c:forEach var="type" items="${typePrets}">
                        <option value="${type.id}">${type.nom}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit">Emprunter</button>
        </form>
    </body>
</html>