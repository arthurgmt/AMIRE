<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>S'inscrire | AMIRE</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container mt-5">
    <div class="row col-md-6 offset-md-3">
        <h2>Create New Account</h2>
        <form action="utilisateur" method="post">
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
                <select class="form-control" id="role" name="role">
                    <option value="Student">Etudiant</option>
                    <option value="Teacher">Enseigant</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>

            <input type="hidden" name="action" value="register">
            <button type="submit" class="btn btn-primary">S'inscrire</button>
        </form>
        <p>Vous possédez déjà un compte? <a href="login.jsp">Se connecter</a></p>
    </div>
</div>
</body>
</html>
