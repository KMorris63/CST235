<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Kacey Morris -->
<!-- October 11, 2020 -->
<!-- CST 235 Application Design and Implementation Part 1 -->
<!-- This is a page which displays the first and last name entered in the previous form. -->
<!-- This is my own work, as influenced by class time and examples and the textbook. -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Response Page</title>
</head>
<body>
<!-- get the attribute associated with first name passed from the handler and form -->
Hello <%= request.getAttribute("firstname") %> <br>

It appears that your last name is <%= request.getAttribute("lastname") %> <br>

I hope you have a nice day.

</body>
</html>