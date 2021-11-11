<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MemberJoin Page</h1>
	
	
	
	<form:form modelAttribute="memberVO" enctype="multipart/form-data">
	<div>
		ID <form:input path="id"/>
		<form:errors path="id"></form:errors>
	</div>
	<div>
		PW <form:password path="pw"/>
		<form:errors path="pw"></form:errors>
	</div>
	
	<div>
		PWCheck <form:password path="pwCheck"/>
		<form:errors path="pwCheck"></form:errors>
	</div>

	<div>
		NAME <form:input path="name"/>
		<form:errors path="name"></form:errors>
	</div>
	<div>
		Email <form:input path="email"/>
		<form:errors path="email"></form:errors>
	</div>
	<div>
		age <form:input path="age"/>
		<form:errors path="age"></form:errors>
	</div>
	<div>
		Birth <form:input path="birth"/>
		<form:errors path="birth"></form:errors>
	</div>
	<div>
		<button>join</button>
	</div>
	
	</form:form>
	
	
	
	
	
	


</body>
</html>