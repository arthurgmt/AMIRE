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

        <button type="button" class="btn btn-success" onclick="showAddUserForm()">Ajouter un utilisateur</button>

        <!-- Div contenant le formulaire, masqué initialement -->
        <div id="addUserForm" style="display:none;">
            <!-- Formulaire d'ajout d'utilisateur -->
            
            <form action="utilisateur" method="post" id="registrationForm">
                <!-- Champs existants -->
                <!-- ... -->
    
                <div class="form-group">
                    <label for="nom">Last Name:</label>
                    <input type="text" class="form-control" id="nom" name="nom" required>
                </div>
    
                <div class="form-group">
                    <label for="prenom">First Name:</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" required>
                </div>
    
                <div class="form-group">
                    <label for="mail">Email:</label>
                    <input type="email" class="form-control" id="mail" name="mail" required>
                </div>
    
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="pwd" name="motDePasse" required>
                </div>
    
                <div class="form-group">
                    <label for="role">Role:</label>
                    <select class="form-control" id="role" name="role" onchange="displayFields(this)">
                        <option value="Admin">Admin</option>
                        <option value="Enseignant">Enseignant</option>
                        <option value="Recruteur">Recruteur</option>
                    </select>
                </div>
    
                <!-- Champs supplémentaires pour Enseignant -->
                <div id="enseignant-fields" class="extra-fields" style="display:none;">
                    <div class="form-group">
                        <label for="Competence">Compétence:</label>
                        <input type="text" class="form-control" id="Competence" name="Competence">
                    </div>
                    <div class="form-group">
                        <label for="Disponibilite">Disponibilité:</label>
                        <input type="date" class="form-control" id="Disponibilite" name="Disponibilite">
                    </div>
                    <div class="form-group">
                        <label for="Telephone">Téléphone:</label>
                        <input type="text" class="form-control" id="Telephone" name="Telephone">
                    </div>
                </div>
    
                <!-- Champs supplémentaires pour Recruteur -->
                <div id="recruteur-fields" class="extra-fields" style="display:none;">
                    <div class="form-group">
                        <label for="RaisonSociale">Raison sociale:</label>
                        <input type="text" class="form-control" id="RaisonSociale" name="RaisonSociale">
                    </div>
                    <div class="form-group">
                        <label for="Adresse">Adresse:</label>
                        <input type="text" class="form-control" id="Adresse" name="Adresse">
                    </div>  
                    <div class="form-group">
                        <label for="Nom">Nom:</label>
                        <input type="text" class="form-control" id="Nom" name="Nom">
                    </div>
                </div>
    
                <input type="hidden" name="action" value="register">
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </form>
        </div>
            
    </c:when>
    <c:otherwise>
        <p>Rôle non reconnu</p>
    </c:otherwise>
</c:choose>

<script>
    function showAddUserForm() {
        var form = document.getElementById("addUserForm");
        if (form.style.display == "block") {
            form.style.display = "none";
        } else {
            form.style.display = "block";
        }
    }

    function displayFields(select) {
        var enseignantFields = document.getElementById('enseignant-fields');
        var recruteurFields = document.getElementById('recruteur-fields');
        enseignantFields.style.display = 'none';
        recruteurFields.style.display = 'none';
        if (select.value === 'Enseignant') {
            enseignantFields.style.display = 'block';
        }
        if (select.value === 'Recruteur') {
            recruteurFields.style.display = 'block';
        }
    }
</script>

</body>
</html>
