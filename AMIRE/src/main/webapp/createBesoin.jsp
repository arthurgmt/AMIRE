<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Create Besoin</title>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-5">
    <h2>Create Besoin</h2>
    <form action="besoin" method="post">
        <div class="mb-3">
            <label for="periode" class="form-label">Période:</label>
            <input type="text" class="form-control" id="periode" name="periode" required>
        </div>

        <div class="mb-3">
            <label for="remarques" class="form-label">Remarques:</label>
            <textarea class="form-control" id="remarques" name="remarques"></textarea>
        </div>

        <div class="mb-3">
            <label for="competences" class="form-label">Compétences nécessaires:</label>
            <textarea class="form-control" id="competences" name="competences" required></textarea>
        </div>

        <input type="hidden" name="action" value="create">
        <button type="submit" class="btn btn-primary">Créer</button>
    </form>
</div>

</body>
</html>
