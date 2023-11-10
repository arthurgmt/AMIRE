<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Modifier Besoin</title>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-5">
    <h2>Modifier Besoin</h2>
    <form action="${pageContext.request.contextPath}/besoin?action=update" method="post">
        <!-- Ajoutez les champs du formulaire en fonction des propriétés du Besoin -->
        <input type="hidden" name="ID" value="${besoin.ID}">
        <div class="mb-3">
            <label for="ecoleID" class="form-label">ID de l'École:</label>
            <input type="text" class="form-control" id="ecoleID" name="ecoleID" value="${besoin.ecoleID}" required>
        </div>

        <div class="mb-3">
            <label for="periode" class="form-label">Période:</label>
            <input type="text" class="form-control" id="periode" name="periode" value="${besoin.periode}" required>
        </div>

        <div class="mb-3">
            <label for="remarques" class="form-label">Remarques:</label>
            <textarea class="form-control" id="remarques" name="remarques">${besoin.remarques}</textarea>
        </div>

        <div class="mb-3">
            <label for="competences" class="form-label">Compétences nécessaires:</label>
            <textarea class="form-control" id="competences" name="competences" required>${besoin.competences}</textarea>
        </div>

        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
</div>

<!-- Ajoutez ici les liens vers les fichiers JavaScript Bootstrap si nécessaire -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
