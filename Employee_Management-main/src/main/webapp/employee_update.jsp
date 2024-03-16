<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        width: 400px;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    }
    .form-group {
        margin-bottom: 20px;
    }
    label {
        display: block;
        font-weight: bold;
    }
    input[type="text"],
    input[type="tel"],
    input[type="email"],
    input[type="password"] {
        width: calc(100% - 20px);
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
 </style>
</head>
<body>

	<%@ page import="java.util.*" import="jsp_employee.*" %>
	
	<div class="container">
	
        <% 
        	List list = (List)request.getAttribute("list"); 
        	EmployeeInfo employeeInfo = (EmployeeInfo)list.get(0);
        %>
	
	    <h2>Employee Registration Form</h2>
	    <form action="update" method="post">
	        <div class="form-group">
	            <label for="id">ID:</label>
	            <input type="text" id="id" name="id" value="<%=employeeInfo.getId() %>" required readonly>
	        </div>
	        <div class="form-group">
	            <label for="name">Name:</label>
	            <input type="text" id="name" name="name" value="<%=employeeInfo.getName() %>" required>
	        </div>
	        <div class="form-group">
	            <label for="phone">Phone:</label>
	            <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" value="<%=employeeInfo.getPhone() %>" required>
	        </div>
	        <div class="form-group">
	            <label for="address">Address:</label>
	            <input type="text" id="address" name="address" value="<%=employeeInfo.getAddress() %>" required>
	        </div>
	        <div class="form-group">
	            <label for="email">Email:</label>
	            <input type="email" id="email" name="email" value="<%=employeeInfo.getEmail() %>" required>
	        </div>
	        <div class="form-group">
	            <label for="password">Password:</label>
	            <input type="password" id="password" name="password" value="<%=employeeInfo.getPassword() %>" required>
	        </div>
	        <input type="submit" value="Submit">
	    </form>
    </div>
</body>
</html>