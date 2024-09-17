<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form Đăng Nhập</title>
    <link rel="stylesheet" href="style.css">
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
        <h1>Đăng nhập</h1>
        <form action="/ltweb05/login" method="post" name="dang-ky">
            <label for="username">Tên tài khoản:</label>
            <input type="text" placeholder="Nhập tên đăng nhập" id="username" name="username" >

            <label for="password">Mật khẩu:</label>
            <input type="password" placeholder="Nhập tên đăng ký" id="password" name="password" >

            <button type="submit" name = "action" value = "Đăng nhập">Đăng nhập</button>
            <button type="submit" name = "action" value = "Đăng ký">Đăng ký</button>
            <button type="submit" name = "action" value = "Quên mật khẩu">Quên mật khẩu</button>
        </form>
    </div>

    <script src="script.js"></script>
</body>
</html>