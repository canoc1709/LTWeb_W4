<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gửi và Xác nhận OTP</title>
<style>
/* style.css */
.container {
	width: 400px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

label {
	display: block;
	margin-bottom: 5px;
}

input[type="text"], input[type="password"] {
	width: 90%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

button {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}
</style>

</head>
<body>
	<div class="container">
		<h2>Quên mật khẩu</h2>
		<form action="/ltweb05/forgotPassword" method="POST">
			<label for="email">Nhập email của bạn:</label> <input type="text"
				id="email" name="email">
			<button type="submit" name="action" value="sendOTP">Gửi mã OTP</button>
			<!-- Hiển thị ô nhập OTP sau khi đã gửi email -->
			<div id="otp-section">
				<label for="otp">Nhập mã OTP:</label> <input type="text" id="otp"
					name="otp">
				<button type="submit" name="action" value="confirmOTP">Xác nhận OTP</button>
			</div>
	</div>

	</form>
</body>
</html>