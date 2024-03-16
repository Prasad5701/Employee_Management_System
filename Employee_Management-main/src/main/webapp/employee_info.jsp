<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Data</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    h2 {
        text-align: center;
        margin-top: 20px;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        border-radius: 5px;
        overflow: hidden;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 10px 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    
    .logout-button {
    padding: 10px 20px;
    margin: 0px 0px 0px 700px;
    background-color: #f44336; /* Red color */
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
}

.logout-button:hover {
    background-color: #d32f2f; /* Darker red color on hover */
}
    
</style>
</head>
<body>

<h2>Employee Data</h2>

<%@ page import="java.util.*" import="jsp_employee.*" %>

<table>
  <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Mobile</th>
      <th>Address</th>
      <th>Email</th>
      <th>Password</th>
      <th>Update</th>
      <th>Delete</th>
    </tr>
  </thead>
  <tbody>
  	<%
  		String value = (String)request.getAttribute("tracking");
  		if(value != null)
  		{
  	%>
  	<h2>Changed By <%= value %></h2>
  	<% } %>
    <%
        List<EmployeeInfo> list = (List<EmployeeInfo>) request.getAttribute("list");
        for (EmployeeInfo employeeInfo : list) {
    %>
        <tr>
          <td><%= employeeInfo.getId() %></td>
          <td><%= employeeInfo.getName() %></td>
          <td><%= employeeInfo.getPhone() %></td>
          <td><%= employeeInfo.getAddress() %></td>
          <td><%= employeeInfo.getEmail() %></td>
          <td><%= employeeInfo.getPassword() %></td>
          <td><a href= "update?id=<%= employeeInfo.getId() %>"><button>Update</button></a></td>
          <td><a href= "delete?id=<%= employeeInfo.getId() %>"><button>Delete</button></a></td>
        </tr>
    <%
        }
    %>
  </tbody>
</table>
<form action="logout" method="post">
	<button class="logout-button">Logout</button>
</form>
</body>
</html>