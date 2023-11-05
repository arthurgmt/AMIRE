<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login | AMIRE</title>
</head>
<body>
<h2>Login to Your Account</h2>
<form action="utilisateur" method="post">
    <label for="mail">Email:</label>
    <input type="email" id="mail" name="mail" required>
    
    <label for="pwd">Password:</label>
    <input type="password" id="pwd" name="motDePasse" required>

    <input type="hidden" name="action" value="register">
    <input type="submit" value="Login">
</form>
<p>Not registered? <a href="register.jsp">Create an account</a></p>
</body>
</html>
