<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ page session="true" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Accueil</title>
        </head>

        <body>
            <h1>Bienvenue dans la bibliothèque</h1>
            <a href="/deconnexion">Se déconnecter</a>
            <p>Rôle connecté :
                <strong>
                    <%= session.getAttribute("role") !=null ? session.getAttribute("role") : "Inconnu" %>
                </strong>
            </p>
            <a href="/exemplaire/list">Liste des exemplaires</a>
        </body>

        </html>