<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Edit Employee</title>
</head>
<body style="background-color:pink;">

<h1>Edit Employee</h1>

<form action="Controller" method="post">

    <!-- REQUIRED: send key into SaveChanges -->
    <input type="hidden" name="action" value="SaveChanges">
    <input type="hidden" name="originalKey" value="${originalKey}">

    <label>Employee ID:</label>
    <input type="text" name="employeeID" value="${person.employeeID}"><br>

    <label>First Name:</label>
    <input type="text" name="firstName" value="${person.firstName}"><br>

    <label>Middle Name:</label>
    <input type="text" name="middleName" value="${person.middleName}"><br>

    <label>Last Name:</label>
    <input type="text" name="lastName" value="${person.lastName}"><br>

    <label>Birth Date:</label>
    <input type="date" name="birthDate" value="${person.birthDate}"><br>

    <label>Hire Date:</label>
    <input type="date" name="hireDate" value="${person.hireDate}"><br>

    <input type="submit" value="Save Changes">
</form>

</body>
</html>
