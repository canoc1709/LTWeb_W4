<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
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
        <h1>Đăng ký</h1>
        <form action = '/ltweb05/register' method = 'post'>
            <label for="username">Tên đăng nhập:</label>
            <input type="text" placeholder="Nhập tên đăng nhập" id="username" name="username" required>

            <label for="password">Mật khẩu:</label>
            <input type="password" placeholder="Nhập mật khẩu" id="password" name="password" required>   


            <label for="email">Email:</label>
            <input type="text" placeholder="Nhập email" id="email" name="email" required>   


            <label for="fullname">Họ và tên:</label>
            <input type="text" placeholder="Nhập họ và tên" id="fullname" name="fullname" required>

            <label for="phone">Số điện thoại:</label>
            <input type="text" placeholder="Nhập số điện thoại" id="phone" name="phone" required>

            <label for="image">Image:</label>
            <input type="text" id="image" name="image" required>

			<label for="roleid">RoleID:</label>
            <input type="text" placeholder="Nhập ID vai trò" id="roleid" name="roleid" required>


            <button type="submit">Đăng ký</button>
        </form>
    </div>

</body>
</html>