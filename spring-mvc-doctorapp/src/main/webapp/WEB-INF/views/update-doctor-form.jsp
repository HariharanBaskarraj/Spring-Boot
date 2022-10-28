<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Doctor</title>
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
<form action="update-doctor">
		<table>
			<tr>
				<th>UPDATE DOCTOR FORM</th>
			</tr>
			<tr>
				<td>Doctor name:</td>
				<td><input type="text" name="doctorName" value=${doctor.doctorName} readonly/></td>
			</tr>
			<tr>
				<td>Doctor id:</td>
				<td><input type="number" name="doctorId" value=${doctor.doctorId} readonly/></td>
			</tr>
			<tr>
				<td>Doctor experience:</td>
				<td><input type="number" name="experience" value=${doctor.experience} readonly/></td>
			</tr>
			<tr>
				<td>Doctor fee:</td>
				<td><input type="text" name="fees" value=${doctor.fees}/></td>
			</tr>
			<tr>
				<td>Doctor specialization:</td>
				<td><input type="radio" name="speciality" value=${doctor.speciality} checked="checked"> 
					<label for="cardio">${doctor.speciality}</label><br>
					<input type="radio" name="speciality" value="Neurologist">
					<label for="neuro">Neurologist</label><br> 
					<input type="radio"	name="speciality" value="Dermatologist"> 
					<label for="derma">Dermatologist</label></td>
			</tr>
			<tr>
				<td>Doctor start time:</td>
				<td><input type="datetime-local" name="startTime" value=${doctor.startTime} readonly></td>
			</tr>
			<tr>
				<td>Doctor end time:</td>
				<td><input type="datetime-local" name="endTime" value=${doctor.endTime} readonly></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Doctor"></td>
			</tr>
		</table>
	</form>
</body>
</html>