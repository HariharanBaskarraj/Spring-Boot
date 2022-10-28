<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: left">
		<a href="home">Home</a>
	</div>
	<form action="getSpecific">
		<table>
			<tr>
				<th>GET PAYING GUEST FORM</th>
			</tr>
			<tr>
				<td>Paying Guest id:</td>
				<td><input type="number" name="payingGuestId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Get PG"></td>
			</tr>
		</table>
	</form>
</body>
</html>