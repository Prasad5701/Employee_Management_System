<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
        width: 300px;
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
	<div class="container">
		
		<%
			String message = (String) request.getAttribute("message");
			if(message != null)
			{
		%>
		<h2><%= message %></h2>
		<%
			}
		%>
		
		<%
			String password = (String) request.getAttribute("password");
			if(password != null)
			{
		%>
		<h4><%= password %></h4>
		<%
			}
		%>
		
	    <h2>Login</h2>
	    <form action="employee_login" method="post">
	        <div class="form-group">
	            <label for="email">Email:</label>
	            <input type="email" id="email" name="email" required>
	        </div>
	        <div class="form-group">
	            <label for="password">Password:</label>
	            <input type="password" id="password" name="password" required>
	        </div>
	        <input type="submit" value="Login">
	    </form>
	</div>
</body>
</html>