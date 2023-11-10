<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Liste des postes</title>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-5">
    <h2>Liste des postes disponibles</h2>

    <c:if test="${not empty besoins}">

        <h3>Rechercher un poste grâce au nom de l'école !</h3>
        <form action="besoin" method="get">
            <input type="hidden" name="action" value="getbyname">
            <c:if test="${not empty recherche}">
                <input type="texte" name="name" value="${recherche}">
            </c:if>
            <c:if test="${empty recherche}">
                <input type="texte" name="name">
            </c:if>
            <button type="submit" class="btn btn-secondary">Rechercher</button>
        </form>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Ecole</th>
                <th>Periode</th>
                <th>Remarques</th>
                <th>Competences</th>
                <th>Postuler</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="besoin" items="${besoins}">
                <tr>
                    <td>${besoin.ecole.nom}</td>
                    <td>${besoin.periode}</td>
                    <td>${besoin.remarques}</td>
                    <td>${besoin.competences}</td>
                    <form action="candidature" method="post">
                        <input type="hidden" name="action" value="create">
                        <input type="hidden" name="EnseignantID" value="${enseignant.ID}">
                        <input type="hidden" name="BesoinID" value="${besoin.ID}">
                        <td><button type="submit" class="btn btn-primary">Postuler</button></td>
                    </form>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty besoins}">
        <p>Aucun besoin trouvé.</p>
    </c:if>
</div>
</body>
</html>
