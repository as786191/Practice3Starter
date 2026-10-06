<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="business.Person"%>
<%@page import="java.util.ArrayList"%>



<html>
    <head>
        <meta charset="utf-8">
        <title>INFO2514 Practice 3</title>
    </head>
    <body>

    <h2>${error}</h2>
    <h1>Employee Info:</h1>
  <table>
    <tr>
        <th>Count</th>
        <th>Key</th>
        <th>Employee Id</th>
        <th>First Name</th>
        <th>Middle Name</th>
        <th>Last Name</th>
        <th>Birth Date</th>
        <th>Hire Date</th>
        
    </tr>

    <c:forEach var="item" items="${linkMap}" varStatus="status">
        <tr>
            <td> ${status.count} </td>
               <td> ${item.key} </td>
               <td> ${item.value.employeeID} </td>
                <td> ${item.value.firstName}</td>
                <td> ${item.value.middleName} </td>
                <td> ${item.value.lastName} </td>
                <td> ${item.value.birthDate} </td>
                <td> ${item.value.hireDate} </td>
                

                <td>
                    <form action="Controller" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="key" value= "${item.key}">
                     <input type="submit" value="Delete">
                    </form>
                </td>
    </tr>
            </c:forEach>  
        </table>
    
    <br> 
    
    <form action="Controller" method="post">
                    <input type="hidden" name="action" value="reset">
                     <input type="submit" value="reset">
                    </form>
                     
   

</body>
</html>
 
<style>
    table {
        background-color: hotpink;
     border: 1px solid black;
     border-collapse: collapse;
     }
     
     th, td {  border: 1px solid black;
     text-align: left; 
     padding: .5em;
     }
     
     html {
         background-color: pink;
     }
  
    
</style>

   

