<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/guestbook2/gbc" method="get">
		비밀번호 <input type="password" name="password">
		<button type="submit">확인</button>
		<br>
		<a href="./WEB-INF/addlist.jsp">메인으로 돌아가기</a>
	</form>

</body>
</html>