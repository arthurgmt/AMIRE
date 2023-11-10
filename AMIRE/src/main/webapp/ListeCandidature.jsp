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

    <c:if test="${not empty candidatures}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Ecole</th>
                <th>Periode</th>
                <th>Remarques</th>
                <th>Competences</th>
                <th>Supprimer</th>
            </tr>
            </thead>
            <tbody>
            <p>${candidatures}</p>
            <c:forEach var="candi" items="${candidatures}">
                <tr>
                    <td>${candi.besoin.ecole.nom}</td>
                    <td>${candi.besoin.periode}</td>
                    <td>${candi.besoin.remarques}</td>
                    <td>${candi.besoin.competences}</td>
                    <form name="delete${candi.ID}" action="candidature" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="ID" value="${candi.ID}">
                        <input type="hidden" name="EnseignantID" value="${candi.enseignant.ID}">
                        <td><button type="submit" class="btn btn-danger">Supprimer</button></td>
                    </form>
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
