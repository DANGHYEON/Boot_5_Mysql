<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/test.css">
</head>
<body>
	<h1>index page</h1>
	
	<c:choose>
	<c:when test="${not empty member}">
		<h3>${member.name}님 환영합니다.</h3>
		<a href="./member/memberLogout">logout</a>
	</c:when>
	<c:otherwise>
		<a href="./member/memberLogin">Login</a>
		<a href="./member/memberJoin">Join</a>
	</c:otherwise>
	</c:choose>
	<img alt="" src="./images/img1.jpg">
</body>
</html>