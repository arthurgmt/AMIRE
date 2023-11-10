<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Décision</title>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-5">
    <h2>Décision</h2>
    <c:if test="${not empty decision}">
        <form name="update" action="decision" method="post">
            <div class="mb-3">
                <label for="status" class="form-label">Statut:</label>
                <input type="text" class="form-control" id="statuss" name="status" required  value="${decision.Statut}">
            </div>

            <div class="mb-3">
                <label for="commentaire" class="form-label">Commentaire:</label>
                <textarea class="form-control" id="commentaires" name="commentaire" value="${decision.Commentaires}"></textarea>
            </div>
            <input type="hidden" name="candiID" value="${candiID}">
            <input type="hidden" name="besoinID" value="${besoinID}">
            <input type="hidden" name="decisionID" value="${decision.id}">

            <input type="hidden" name="action" value="update">
            <button type="submit" class="btn btn-primary">Mettre à jour</button>
        </form>
    </c:if>
    <c:if test="${empty decision}">
        <form name="create" action="decision" method="post">
            <div class="mb-3">
                <label for="status" class="form-label">Statut:</label>
                <input type="text" class="form-control" id="status" name="status" required>
            </div>

            <div class="mb-3">
                <label for="commentaire" class="form-label">Commentaire:</label>
                <textarea class="form-control" id="commentaire" name="commentaire"></textarea>
            </div>
            <input type="hidden" name="candiID" value="${candiID}">
            <input type="hidden" name="besoinID" value="${besoinID}">

            <input type="hidden" name="action" value="create">
            <button type="submit" class="btn btn-primary">Créer</button>
        </form>
    </c:if>
</div>

</body>
</html>
