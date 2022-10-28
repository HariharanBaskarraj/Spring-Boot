<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Doctor Form</title>
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
	<form action="add-doctor">
		<table>
			<tr>
				<th>ADD DOCTOR FORM</th>
			</tr>
			<tr>
				<td>Doctor name:</td>
				<td><input type="text" name="doctorName" /></td>
			</tr>
			<tr>
				<td>Doctor experience:</td>
				<td><input type="number" name="experience" /></td>
			</tr>
			<tr>
				<td>Doctor fee:</td>
				<td><input type="text" name="fees" /></td>
			</tr>
			<tr>
				<td>Doctor specialization:</td>
				<td><input type="radio" name="speciality"
					value="Cardiologist"> <label for="cardio">Cardiologist</label><br>
					<input type="radio" name="speciality" value="Neurologist">
					<label for="neuro">Neurologist</label><br> <input type="radio"
					name="speciality" value="Dermatologist"> <label
					for="derma">Dermatologist</label></td>
			</tr>
			<tr>
				<td>Doctor start time:</td>
				<td><input type="datetime-local" name="startTime"></td>
			</tr>
			<tr>
				<td>Doctor end time:</td>
				<td><input type="datetime-local" name="endTime"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Doctor"></td>
			</tr>
		</table>
	</form>
</body>
</html>