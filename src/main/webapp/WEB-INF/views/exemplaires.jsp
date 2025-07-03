<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Exemplaires</title>
</head>
<body>
    <h2>Liste des exemplaires</h2>
    <table border="1">
        <tr>
            <th>ID</th>
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
                <td>${ex.id}</td>
                <td>${ex.titre}</td>
                <td>${ex.auteur}</td>
                <td>${ex.etat}</td>
                <td>${ex.getStatut().getNom()}</td>
                <c:if test="${sessionScope.role == 'adherent'}">
                <td>
                        <form action="reserver" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${ex.id}" />
                            <button type="submit">Reserver</button>
                        </form>
                        <form action="preter" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${ex.id}" />
                            <button type="submit" <c:if test="${ex.statut == 'emprunté'}">disabled</c:if>>Prêter</button>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <a href="/accueil">Accueil</a>
</body>
</html>
