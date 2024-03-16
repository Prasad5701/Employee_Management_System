<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.container {
	max-width: 800px;
	margin: 50px auto;
	text-align: center;
}

h1 {
	color: #333;
}

.options {
	margin-top: 30px;
}

.options button {
	padding: 10px 20px;
	margin: 10px;
	font-size: 16px;
	cursor: pointer;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	transition: background-color 0.3s ease;
}

.options button:hover {
	background-color: #0056b3;
}

.input-container {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-top: 20px;
}

.input-container input[type="text"] {
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 5px;
	width: 200px;
	margin-right: 10px;
}

.input-container button {
	padding: 8px 15px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
</style>

</head>
<body>
	<div class="container">
		<h1>Welcome to Employee Management System</h1>
		<div class="options">

			<form action="info" method="post">
				<button>View Employee Details</button>
				<br>
			</form>


			<button class="btn" onclick="showInputField()">View Employee
				Details by ID</button>

			<form action="info" method="post">

				<div class="input-container" id="input-container"
					style="display: none;">
					<input type="text" id="id" name="id"
						placeholder="Enter Employee ID">
					<button class="btn">Submit</button>
				</div>
			</form>
			<br>
			
			
		</div>
	</div>
	</div>
	
	<script>
		function showInputField() {
			var inputContainer = document.getElementById("input-container");
			inputContainer.style.display = "flex";
		}
		
		function showInputField1() {
			var inputContainer = document.getElementById("input-container1");
			inputContainer.style.display = "flex";
		}
	</script>
</body>
</html>