<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	
	<h1 style ="color: #F5C518;">Log in</h1>
	<form action="LogIn" method="GET" align="center" style="display: block; margin:1%">
		<label for="LogInEmail">E-mail:</label>
		<input type="email" id="LogInEmail" name="LogInEmail" required> 
	
		<label for="LogInPW">Password:</label>
		<input type="password" id="LogInPW" name="LogInPW" required> <br> <br>
	
		<input type="submit" value="LOG IN" style = "width:10%">
	</form>


    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/mustache.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/main.js"></script>
    
</body>
</html>