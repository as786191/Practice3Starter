<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Employee Info</title>
</head>
<body style="background-color:pink;">

<h2>${error}</h2>
<h1>Employee Info:</h1>

<form action="Controller" method="post">
    <input type="hidden" name="action" value="add">

    <label>Key:</label>
    <input type="text" name="key"><br>

    <label>Employee ID:</label>
    <input type="text" name="employeeID"><br>

    <label>First Name:</label>
    <input type="text" name="firstName"><br>

    <label>Middle Name:</label>
    <input type="text" name="middleName"><br>

    <label>Last Name:</label>
    <input type="text" name="lastName"><br>

    <label>Birth Date:</label>
    <input type="date" name="birthDate"><br>

    <label>Hire Date:</label>
    <input type="date" name="hireDate"><br>

    <input type="submit" value="Add">
</form>

<table style="background-color:hotpink;border:1px solid black;border-collapse:collapse;">
    <tr>
        <th>Key</th><th>ID</th><th>First</th><th>Middle</th><th>Last</th>
        <th>Birth</th><th>Hire</th><th>Edit</th><th>Delete</th>
    </tr>

    <c:forEach var="item" items="${linkMap}">
        <tr>
            <td>${item.key}</td>
            <td>${item.value.employeeID}</td>
            <td>${item.value.firstName}</td>
            <td>${item.value.middleName}</td>
            <td>${item.value.lastName}</td>
            <td>${item.value.birthDate}</td>
            <td>${item.value.hireDate}</td>

            <td>
                <!-- THIS is the fix: send item.key -->
                <form action="Controller" method="post">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="originalKey" value="${item.key}">
                    <input type="submit" value="Edit">
                </form>
            </td>

            <td>
                <form action="Controller" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="key" value="${item.key}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="Controller" method="post">
    <input type="hidden" name="action" value="reset">
    <input type="submit" value="Reset">
</form>

</body>
</html>
