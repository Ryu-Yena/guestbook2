<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.GuestVo" %>


<%
	List<GuestVo> guestList = (List<GuestVo>)request.getAttribute("gList"); //형변환 필수
	System.out.println(guestList);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="/guestbook2/gbc" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td colspan="4"><input type="text" name="name"></td>
				<td colspan="2">비밀번호</td>
				<td colspan="4"><input type="password" name="password"></td>
			</tr>
			
			<tr>
				<td colspan="11"><textarea rows="4" cols="65"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="11"><button type="submit">확인</button></td>
			</tr>
		</table>
	</form>

	<c:forEach items="${guestList}" var="guestList">
		<table border="1">
			<tr>
				<td>${gustList.no}</td>
				<td colspan="2">${gustList.name}</td>
				<td colspan="6">${gustList.reg_date}</td>
				<td colspan="2"><a href="">삭제</a>
			</tr>
			
			<tr>
				<td colspan="11">${gustList.content}</td>
			</tr>
		</table>
		<br>
	</c:forEach>


</body>
</html>