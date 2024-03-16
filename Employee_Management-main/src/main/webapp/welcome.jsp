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
        text-align: center;
    }
    .btn {
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    .btn.signup {
        background-color: #4CAF50;
        color: white;
    }
    .btn.signup:hover {
        background-color: #45a049;
    }
    .btn.login {
        background-color: #3498db;
        color: white;
        margin-left: 20px;
    }
    .btn.login:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>
	<div class="container">
    	<a href="employee_signup.jsp"><button class="btn signup">SignUp</button></a>
    	<a href="employee_login.jsp"><button class="btn login">Login</button></a>
	</div>
	
</body>
</html>