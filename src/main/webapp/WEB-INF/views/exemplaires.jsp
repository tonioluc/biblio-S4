<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Liste des Exemplaires</title>
</head>

<body>
    <h2>Liste des exemplaires</h2>

    <c:if test="${not empty erreur}">
        <div style="color: red; font-weight: bold;">
            ${erreur}
        </div>
    </c:if>

    <table border="1">
        <tr>
            <th>Titre</th>
            <th>Auteur</th>
            <th>État</th>
            <th>Statut</th>
            <c:if test="${sessionScope.role == 'adherent'}">
                <th>Action</th>
            </c:if>
        </tr>
        <c:forEach var="ex" items="${exemplaires}">
            <tr>
                <td>${ex.titre}</td>
                <td>${ex.auteur}</td>
                <td>${ex.getEtat().getNom()}</td>
                <td>${ex.getStatut().getNom()}</td>
                <c:if test="${sessionScope.role == 'adherent'}">
                    <td>
                        <a href=""><button type="submit">Reserver</button></a>
                        <a href="/adherent/emprunter-livre/${ex.id}">
                            <button type="submit">Prêter</button>
                        </a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <a href="/accueil">Accueil</a>
</body>

</html>