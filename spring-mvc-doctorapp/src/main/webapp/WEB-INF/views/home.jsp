<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
<div style="text-align: right">
	<a href="admin">Admin Page</a>
	</div>
	<h2>Search by category:</h2>
	<form action="search-doctor">
		<select name="choice">
			<option value="--Select--">Select</option>
			<option value="Cardiologist">Cardiologist</option>
			<option value="Neurologist">Neurologist</option>
			<option value="Opthalmologist">Opthalmologist</option>
			<option value="Pediatrician">Pediatrician</option>
		</select> <input type="submit" value="Search">
	</form>
	
	<h2>All doctors:</h2>
	${doctors}
	${message}		
</body>
</html>