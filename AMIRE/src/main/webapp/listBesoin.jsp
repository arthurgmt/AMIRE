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
                <th>Actions</th> <!-- Nouvelle colonne pour les boutons d'action -->
            </tr>
            </thead>
            <tbody>
            <c:forEach var="besoin" items="${besoins}">
                <tr>
                    <td>${besoin.ID}</td>
                    <td>${besoin.ecoleID}</td>
                    <td>${besoin.periode}</td>
                    <td>${besoin.remarques}</td>
                    <td>${besoin.competences}</td>
                    <td>
                        <!-- Bouton pour modifier le besoin -->
                        <a href="${pageContext.request.contextPath}/besoin?action=redirectUpdate&id=${besoin.ID}">
                            <button type="button" class="btn btn-warning">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-tools" viewBox="0 0 16 16">
                                    <path d="M1 0 0 1l2.2 3.081a1 1 0 0 0 .815.419h.07a1 1 0 0 1 .708.293l2.675 2.675-2.617 2.654A3.003 3.003 0 0 0 0 13a3 3 0 1 0 5.878-.851l2.654-2.617.968.968-.305.914a1 1 0 0 0 .242 1.023l3.27 3.27a.997.997 0 0 0 1.414 0l1.586-1.586a.997.997 0 0 0 0-1.414l-3.27-3.27a1 1 0 0 0-1.023-.242L10.5 9.5l-.96-.96 2.68-2.643A3.005 3.005 0 0 0 16 3c0-.269-.035-.53-.102-.777l-2.14 2.141L12 4l-.364-1.757L13.777.102a3 3 0 0 0-3.675 3.68L7.462 6.46 4.793 3.793a1 1 0 0 1-.293-.707v-.071a1 1 0 0 0-.419-.814L1 0Zm9.646 10.646a.5.5 0 0 1 .708 0l2.914 2.915a.5.5 0 0 1-.707.707l-2.915-2.914a.5.5 0 0 1 0-.708ZM3 11l.471.242.529.026.287.445.445.287.026.529L5 13l-.242.471-.026.529-.445.287-.287.445-.529.026L3 15l-.471-.242L2 14.732l-.287-.445L1.268 14l-.026-.529L1 13l.242-.471.026-.529.445-.287.287.445.529-.026L3 11Z"></path>
                                </svg>
                                Modifier
                            </button>
                        </a>

                        <!-- Bouton pour supprimer le besoin avec confirmation -->
                        <a href="${pageContext.request.contextPath}/besoin?action=delete&id=${besoin.ID}">
                            <button type="button" class="btn btn-outline-danger">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"></path>
                                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"></path>
                                </svg>
                                Supprimer
                            </button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty besoins}">
        <p>Aucun besoin trouvé.</p>
    </c:if>

    <!-- Script JavaScript pour la confirmation de suppression -->
    <script>
        function confirmDelete(besoinId) {
            console.log("BesoinId = " + besoinId);
            var confirmation = confirm("Êtes-vous sûr de vouloir supprimer ce besoin ?");
            if (confirmation) {
                // Rediriger vers la servlet de suppression avec l'ID du besoin
                window.location.href = "${pageContext.request.contextPath}/besoin?action=delete&id=" + besoinId;
            }
        }
    </script>
</div>

</body>
</html>
