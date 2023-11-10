<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tableau de bord | AMIRE</title>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-4">
    <h2>Tableau de Bord</h2>

    <c:choose>
        <c:when test="${user.role eq 'Enseignant'}">
            <h3>Liste de Candidatures :</h3>
            <div class="list-group">
                <c:forEach items="${candidatures}" var="candidature">
                    <a href="#" class="list-group-item list-group-item-action">
                        <h5 class="mb-1">${candidature.besoin.ecole.nom}</h5>
                        <p class="mb-1">Période: ${candidature.besoin.periode}</p>
                        <p class="mb-1">Remarques: ${candidature.besoin.remarques}</p>
                        <p class="mb-1">Compétences: ${candidature.besoin.competences}</p>
                    </a>
                </c:forEach>
            </div>
        </c:when>
        <c:when test="${user.role eq 'Recruteur'}">
            <h3>Liste des besoins :</h3>
            <div class="list-group">
                <c:forEach items="${besoins}" var="besoin">
                    <a href="#" class="list-group-item list-group-item-action">
                        <h5 class="mb-1">${besoin.ecole.nom}</h5>
                        <p class="mb-1">Période: ${besoin.periode}</p>
                        <p class="mb-1">Remarques: ${besoin.remarques}</p>
                        <p class="mb-1">Compétences: ${besoin.competences}</p>
                    </a>
                </c:forEach>
            </div>
        </c:when>
        <c:when test="${user.role eq 'Admin'}">
            <h3>Liste d'Utilisateurs :</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Email</th>
                    <th>Role</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="utilisateur" items="${utilisateurs}">
                    <tr>
                        <td>${utilisateur.nom}</td>
                        <td>${utilisateur.prenom}</td>
                        <td>${utilisateur.mail}</td>
                        <td>${utilisateur.role}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>Rôle non reconnu</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
