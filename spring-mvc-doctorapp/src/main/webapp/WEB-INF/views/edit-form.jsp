<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit form</title>
<style>
table, th, td {
	padding: 5px;
	border-collapse: collapse;
}
</style>
</head>
<body>
<div style="text-align: left">
	<a href="home">Home</a>
	</div>
	<form action="getOne">
		<table>
			<tr>
				<th>GET DOCTOR FORM</th>
			</tr>
			<tr>
				<td>Doctor id:</td>
				<td><input type="number" name="doctorId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Get Doctor"></td>
			</tr>
		</table>
	</form>
</body>
</html>