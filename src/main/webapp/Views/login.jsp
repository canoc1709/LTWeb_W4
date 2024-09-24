<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="http://localhost:5740/btltw_04/views/login.css">
    <title>Đăng nhập</title>
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