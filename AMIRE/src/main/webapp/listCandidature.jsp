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
    <h2>Liste de vos candidatures</h2>

    <h3>Rechercher un poste grâce au nom de l'école !</h3>
    <form action="candidature" method="get">
        <input type="hidden" name="action" value="getbycompetenceandbesoinid">
        <input type="hidden" name="besoinID" value="${besoinID}">
        <c:if test="${not empty recherche}">
            <input type="texte" name="competence" value="${recherche}">
        </c:if>
        <c:if test="${empty recherche}">
            <input type="texte" name="competence">
        </c:if>
        <button type="submit" class="btn btn-secondary">Rechercher</button>
    </form>

    <c:if test="${not empty candidatures}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Nom prénom</th>
                <th>Contact</th>
                <th>Expérience</th>
                <th>Site web</th>
                <th>Competences</th>
                <th>Disponibilités</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <p>${candidatures}</p>
            <c:forEach var="candi" items="${candidatures}">
                <tr>
                    <td>${candi.enseignant.utilisateur.nom} ${candi.enseignant.utilisateur.prenom}</td>
                    <td>${candi.enseignant.utilisateur.email} - ${candi.enseignant.telephone}</td>
                    <td>${candi.enseignent.experience}</td>
                    <td>${candi.enseignant.siteweb}</td>
                    <td>${candi.enseignant.competences}</td>
                    <td>${candi.enseignant.disponibilité}</td>
                    <td>
                        <a href="enseignant?action=get&id=${candi.enseignant.ID}" class="btn btn-primary">Voir</a>
                        <a href="decision?action=beforecreate&candiID=${candi.ID}&besoinID=${besoinID}" class="btn btn-danger">Décision</a>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty candidatures}">
        <p>Aucune candidature trouvée.</p>
    </c:if>
</div>
</body>
</html>
