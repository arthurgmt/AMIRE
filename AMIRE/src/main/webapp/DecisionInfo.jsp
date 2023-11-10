<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <h2>Décision concernant la candidature : </h2>


    <c:if test="${not empty decision}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Statut</th>
                <th>Commentaires</th>
                <th>Date de la décision</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${decision.statut}</td>
                <td>${decision.commentaires}</td>
                <td>${decision.dateDecision}</td>
            </tr>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty decision}">
        <p>Aucune décision trouvée.</p>
    </c:if>
</div>
</body>
</html>
