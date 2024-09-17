<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đặt lại mật khẩu</title>
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

input[type="text"],
input[type="password"] {
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
	<h2>Đặt lại mật khẩu</h2>
    <form action="/ltweb05/resetPassword" method="POST">
        <label for="newPassword">Nhập mật khẩu mới:</label>
        <input type="password" id="newPassword" name="newPassword" required>
        
        <label for="confirmPassword">Xác nhận mật khẩu mới:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
        
        <button type="submit">Đặt lại mật khẩu</button>
    </form>
    </div>
</body>
</html>
