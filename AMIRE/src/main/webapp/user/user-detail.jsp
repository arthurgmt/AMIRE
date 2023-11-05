<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Detail | AMIRE</title>
</head>
<body>
<h2>User Detail</h2>
<form action="updateUserProfile" method="post">
    <input type="hidden" name="id" value="${user.ID}" />
    <label for="nom">Last Name:</label>
    <input type="text" id="nom" name="nom" value="${user.nom}" required>
    
    <label for="prenom">First Name:</label>
    <input type="text" id="prenom" name="prenom" value="${user.prenom}" required>
    
    <label for="mail">Email:</label>
    <input type="email" id="mail" name="mail" value="${user.mail}" required>
    
    <label for="role">Role:</label>
    <select id="role" name="role">
        <option value="Recruteur" ${user.role == 'Recruteur' ? 'selected' : ''}>Student</option>
        <option value="Teacher" ${user.role == 'Teacher' ? 'selected' : ''}>Teacher</option>
        <option value="Admin" ${user.role == 'Admin' ? 'selected' : ''}>Admin</option>
    </select>
    
    <input type="submit" value="Update Profile">
</form>

<a href="deleteUserProfile?id=${user.ID}">Delete Profile</a>
</body>
</html>
