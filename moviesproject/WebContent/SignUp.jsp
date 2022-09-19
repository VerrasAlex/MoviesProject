<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
    
    <h1 style ="color: #F5C518;">Sign Up</h1>
	<form action="SignUp"  align="center" style="display: block; margin:1%">
			<label for="SignUpEmail">E-mail:</label>
			<input type="email" id="SignUpEmail" name="SignUpEmail" required> 
		
			<label for="SignUpPW">Password:</label>
			<input type="password" id="SignUpPW" name="SignUpPW" required> <br> <br>
		
			<input type="submit" value="SIGN UP">
	</form>

</body>
</html>