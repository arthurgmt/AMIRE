<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register | AMIRE</title>
</head>
<body>
<h2>Create New Account</h2>
<form action="register" method="post">
    <label for="nom">Last Name:</label>
    <input type="text" id="nom" name="nom" required>
    
    <label for="prenom">First Name:</label>
    <input type="text" id="prenom" name="prenom" required>
    
    <label for="mail">Email:</label>
    <input type="email" id="mail" name="mail" required>
    
    <label for="pwd">Password:</label>
    <input type="password" id="pwd" name="motDePasse" required>
    
    <label for="role">Role:</label>
    <select id="role" name="role">
        <option value="Student">Student</option>
        <option value="Teacher">Teacher</option>
        <option value="Admin">Admin</option>
    </select>
    
    <input type="submit" value="Register">
</form>
<p>Already registered? <a href="login.jsp">Sign in</a></p>
</body>
</html>
