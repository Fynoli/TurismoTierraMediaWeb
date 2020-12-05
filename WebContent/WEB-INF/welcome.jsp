<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%

	String usuario = (String) request.getSession().getAttribute("usuario");

%>

<%

	if (usuario != null) {
		%>
		
		<h1>Bienvenid@ ${usuario}</h1>
		
		<a href="logout">Salir</a>
		
		<%
	}

%>



</body>
</html>