<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>S'inscrire | AMIRE</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        .extra-fields {
            display: none;
        }

        #role {
            /* Ajout d'un écouteur d'événement sur le changement de sélection */
            onchange: "displayFields(this)";
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container mt-5">
    <div class="row col-md-6 offset-md-3">
        <h2>Create New Account</h2>
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
            <div id="enseignant-fields" class="extra-fields">
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
            <div id="recruteur-fields" class="extra-fields">
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
                    <input type="text" class="form-control" id="NomEcole" name="Nom">
                </div>
            </div>

            <input type="hidden" name="action" value="register">
            <button type="submit" class="btn btn-primary">S'inscrire</button>
        </form>
        <p>Vous possédez déjà un compte? <a href="login.jsp">Se connecter</a></p>
    </div>
</div>

<script>
    function displayFields(select) {
        var enseignantFields = document.getElementById('enseignant-fields');
        var recruteurFields = document.getElementById('recruteur-fields');
        // Masquer tous les champs supplémentaires
        enseignantFields.style.display = 'none';
        recruteurFields.style.display = 'none';
        // Afficher les champs pour le rôle sélectionné
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
