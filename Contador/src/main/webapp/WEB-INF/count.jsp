<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styleCounters.css">
<meta charset="ISO-8859-1">
<title>Current visit count</title>
</head>
<body>
	<p>
		You have visited <a href="">localhost:8080</a>
		<c:out value="${contador}"></c:out>
		times
	</p>
	<a href="/">Test another visit?</a>
	<p>
		<a href="/reset"><button>Click here to reset</button></a>
	</p>
</body>
</html>