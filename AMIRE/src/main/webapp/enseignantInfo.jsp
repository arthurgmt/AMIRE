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
    <h2>Informations du candidat : </h2>


    <c:if test="${not empty enseignant}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Nom prénom</th>
                <th>Expérience</th>
                <th>Téléphone</th>
                <th>Site web</th>
                <th>Niveaux souhaités</th>
                <th>Disponibilités</th>
                <th>Type de contrat</th>
                <th>Titres académiques</th>
                <th>Evaluations</th>
                <th>Autres informations</th>
                <th>Compétences</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${enseignant.utilisateur.Nom} ${enseignant.utilisateur.Prenom}</td>
                    <td>${enseignant.experience}</td>
                    <td>${enseignant.telephone}</td>
                    <td>${enseignant.siteweb}</td>
                    <td>${enseignant.niveauxsouhaites}</td>
                    <td>${enseignant.disponibilites}</td>
                    <td>${enseignant.typecontrat}</td>
                    <td>${enseignant.titresacademiques}</td>
                    <td>${enseignant.evaluations}</td>
                    <td>${enseignant.autresinformations}</td>
                    <td>${enseignant.competences}</td>
                </tr>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty enseignant}">
        <p>Aucune candidature trouvée.</p>
    </c:if>
</div>
</body>
</html>
