<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="menu.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all leads</title>
</head>
<body>

   <h2>All Leads</h2>
   
   <table>
      <tr>
         <th>First Name</th>
         <th>Last Name </th>
         <th>Email</th> 
         <th>Mobile</th>
         <th>Delete</th>  
         <th>Update</th> 
      </tr>
      
   <c:forEach var="Lead" items="${leads}" >
     <tr>
         <td>${Lead.firstName}</td>
         <td>${Lead.lastName}</td>
         <td>${Lead.email}</td>
         <td>${Lead.mobile}</td>
         <td><a href="delete?id=${Lead.id}" >delete</a></td>
         <td><a href="update?id=${Lead.id}" >update</a></td>
     </tr>
   </c:forEach>
   
   </table>

</body>
</html>