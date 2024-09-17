<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.account == null}">
        <div class="col-sm-6">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/register">Đăng ký</a>
                </li>
                <li class="nav-item">
                    <i class="nav-link fa fa-search"></i>
                </li>
            </ul>
        </div>
    </c:when>
    <c:otherwise>
        <div class="col-sm-6">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/member/myaccount">${sessionScope.account.fullname}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Đăng Xuất</a>
                </li>
                <li class="nav-item">
                    <i class="nav-link fa fa-search"></i>
                </li>
            </ul>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>