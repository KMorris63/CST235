<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Kacey Morris -->
<!-- October 11, 2020 -->
<!-- CST 235 Application Design and Implementation Part 1 -->
<!-- This is a page which asks for input from the user for their first and last name and sends it to the handler. -->
<!-- This is my own work, as influenced by class time and examples and the textbook. -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<!-- when submit is selected, the handle form input will be accessed -->
	<form action="HandleFormInput" method="get">
	<!-- input for first and last name -->
		First Name:<br>
		<input type="text" name="firstname" value="Kacey">
		<br>
		Last Name:<br>
		<input type="text" name="lastname" value="Morris">
		<br>
		<!-- submit button to submit to handler -->
		<input type="submit" value="Submit">
	</form>
</body>
</html>