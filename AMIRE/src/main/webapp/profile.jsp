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
        <h3>Profile Enseignant:</h3>
        <!-- <%-- Form for Enseignant --%> -->
        <form action="enseignant" method="post">
            <input type="hidden" name="id" value="${enseignantID}">
            <input type="number" name="Experience" placeholder="Experience" value="${enseignant.experience}">
            <input type="text" name="Telephone" placeholder="Telephone" value="${enseignant.telephone}">
            <input type="text" name="SiteWeb" placeholder="SiteWeb" value="${enseignant.siteweb}">            
            <input type="text" name="NiveauxSouhaites" placeholder="NiveauxSouhaites" value="${enseignant.niveauxsouhaites}">            
            <input type="date" name="Disponibilites" placeholder="Disponibilites" value="${enseignant.disponibilites}">            
            <input type="text" name="TypeContrat" placeholder="TypeContrat" value="${enseignant.typecontrat}">            
            <input type="text" name="TitresAcademiques" placeholder="TitresAcademiques" value="${enseignant.titresacademiques}">            
            <input type="text" name="Evaluations" placeholder="Evaluations" value="${enseignant.evaluations}">            
            <input type="text" name="AutresInformations" placeholder="AutresInformations" value="${enseignant.autresinformations}">            
            <input type="text" name="Competences" placeholder="Competences" value="${enseignant.competences}">            

            <input type="hidden" name="action" value="update">
            <button type="submit" class="btn btn-primary">Mettre à jour</button>
        </form>
    </c:when>
    <c:when test="${user.role == 'Recruteur'}">
        <h3>Profile Recruteur:</h3>
        <%-- Form for Recruteur --%>
        <form action="ecole" method="post">
            <input type="hidden" name="id" value="${ecoleID}"> 
            <input type="text" name="RaisonSociale" placeholder="RaisonSociale" value="${ecole.raisonSociale}">
            <input type="text" name="Adresse" placeholder="Adresse" value="${ecole.adresse}">
            <input type="text" name="SiteWeb" placeholder="SiteWeb" value="${ecole.siteWeb}">
            <input type="text" name="Contact" placeholder="Contact" value="${ecole.contact}">
            <input type="text" name="Nom" placeholder="Nom" value="${ecole.nom}">
            
            <input type="hidden" name="action" value="update">
            <button type="submit">Mettre à jour</button>
        </form>
    </c:when>
    <c:otherwise>
        <p>Rôle non reconnu</p>
    </c:otherwise>
</c:choose>
</body>
</html>
