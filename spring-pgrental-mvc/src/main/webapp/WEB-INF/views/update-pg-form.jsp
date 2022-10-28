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
	<form action="update-pg">
		<table>
			<tr>
				<th>UPDATE PAYING GUEST FORM</th>
			</tr>
			<tr>
				<td>Paying Guest id:</td>
				<td><input type="number" name="payingGuestId"
					value=${payingGuest.payingGuestId } readonly /></td>
			</tr>
			<tr>
				<td>Paying Guest name:</td>
				<td><input type="text" name="payingGuestName"
					value=${payingGuest.payingGuestName } readonly /></td>
			</tr>
			<tr>
				<td>Paying Guest location:</td>
				<td><select name="choice" value=${payingGuest.location
					} disabled>
						<option value="Hyderabad" >Hyderabad</option>
						<option value="Delhi">Delhi</option>
						<option value="Coimbatore">Coimbatore</option>
						<option value="Chennai">Chennai</option>
				</select></td>
			</tr>
			<tr>
				<td>Paying Guest category:</td>
				<td><input type="radio" name="category"
					value=${payingGuest.category } checked="checked"> <label
					for="Men">Men</label><br> <input type="radio" name="category"
					value="Women"> <label for="Women">Women</label><br> <input
					type="radio" name="category" value="Co-live"> <label
					for="Co-live">Co-living</label></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update PG"></td>
			</tr>
		</table>
	</form>
</body>
</html>