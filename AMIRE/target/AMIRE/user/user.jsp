<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Profile | AMIRE</title>
</head>
<body>
<h2>User Profile</h2>
<p>Welcome, ${user.nom} ${user.prenom}</p>
<p></p>
<p></p>

<a href="views/user/user-detail.jsp?id=${user.ID}">View Detailed Profile</a>
</body>
</html>
