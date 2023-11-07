<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tableau de bord | AMIRE</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<%@ include file="navbar.jsp"%>
<h2>Tableau de Bord</h2>

<c:choose>
    <c:when test="${user.role == 'Enseignant'}">
        <h3>Liste de Candidatures :</h3>
        <c:forEach items="${listCandidatures}" var="cours">
            <p>${cours.nomCours}</p>
        </c:forEach>
    </c:when>
    <c:when test="${user.role == 'Recruteur'}">
        <h3>Liste des besoins :</h3>
        <c:forEach items="${listBesoins}" var="offre">
            <p>${offre.nomOffre}</p>
        </c:forEach>
    </c:when>
    <c:when test="${user.role == 'Admin'}">
        <h3>Liste d'Utilisateurs :</h3>
        <c:forEach items="${listUsers}" var="utilisateur">
            <p>${utilisateur.nom} ${utilisateur.prenom}</p>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>Rôle non reconnu</p>
    </c:otherwise>
</c:choose>
</body>
</html>
