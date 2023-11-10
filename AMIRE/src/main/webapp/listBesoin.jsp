<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Liste des Besoins</title>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-5">
    <h2>Liste des Besoins</h2>

    <c:if test="${not empty besoins}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>EcoleID</th>
                <th>Periode</th>
                <th>Remarques</th>
                <th>Competences</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="besoin" items="${besoins}">
                <tr>
                    <td>${besoin.id}</td>
                    <td>${besoin.ecoleId}</td>
                    <td>${besoin.periode}</td>
                    <td>${besoin.remarques}</td>
                    <td>${besoin.competences}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty besoins}">
        <p>Aucun besoin trouvé.</p>
    </c:if>
</div>

</body>
</html>
