<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete PG</title>
</head>
<body>
<div style="text-align: left">
		<a href="home">Home</a>
	</div>
	<form action="delete-pg">
		<table>
			<tr>
				<th>UPDATE PAYING GUEST FORM</th>
			</tr>
			<tr>
				<td>Paying Guest id:</td>
				<td><input type="number" name="payingGuestId"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Delete PG"></td>
			</tr>
		</table>
	</form>
</body>
</html>