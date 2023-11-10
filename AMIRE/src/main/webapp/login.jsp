<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Se connecter | AMIRE</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container mt-5">
    <div class="row col-md-6 offset-md-3">
        <h2>Se connecter</h2>
        <form action="utilisateur" method="post">
            <div class="form-group">
                <label for="mail">Email:</label>
                <input type="email" class="form-control" id="mail" name="mail" required>
            </div>
            <div class="form-group">
                <label for="pwd">Mot de passe:</label>
                <input type="password" class="form-control" id="pwd" name="motDePasse" required>
            </div>
            <input type="hidden" name="action" value="login">
            <button type="submit" class="btn btn-primary">Se connecter</button>
        </form>
        <c:if test="${not empty requestScope.loginError}">
            <div id="login-error" class="alert alert-danger">
            Mauvaise adresse email ou mot de passe.
            </div>
        </c:if>
        <p class="mt-3">Pas de compte ?<a href="/register.jsp">Créer un compte</a></p>
    </div>
</div>
</body>
</html>
