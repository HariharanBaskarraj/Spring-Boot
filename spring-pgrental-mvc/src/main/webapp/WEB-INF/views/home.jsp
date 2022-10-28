<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div style="text-align: right">
		<a href="admin">Admin Page</a>
	</div>
	<h2>Search by category:</h2>
	<form action="pg-category">
		<select name="choice">
			<option value="Men">Men</option>
			<option value="Women">Women</option>
			<option value="Co-live">Co-live</option>
		</select> <input type="submit" value="Search">
	</form>

	<h2>Search by location:</h2>
	<form action="pg-location">
		<select name="choice">
			<option value="Hyderabad">Hyderabad</option>
			<option value="Delhi">Delhi</option>
			<option value="Coimbatore">Coimbatore</option>
			<option value="Chennai">Chennai</option>
		</select> <input type="submit" value="Search">
	</form>

	<h2>Paying Guests:</h2>
	${payingGuests}
</body>
</html>