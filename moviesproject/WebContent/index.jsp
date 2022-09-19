<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieDb</title>
<link rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<h2 align="center" style = "background-color: #F5C518;">MovieDb</h2>
	<hr>
	<div align="center">
		<form action="LogIn.jsp" style="margin:1%">
    		<input type="submit" value="LOG IN" style="padding:.5%"/>
		</form>
		
		<form action="SignUp.jsp" style="margin:1%">
    		<input type="submit" value="SIGN UP" style="padding:.5%"/>
		</form>
	</div>
	
</body>
</html>