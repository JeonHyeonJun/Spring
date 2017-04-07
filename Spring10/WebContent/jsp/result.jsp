<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Loan" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>청구서</title>
</head>
<body>
	<table border=1>
		<tr>
		<th>회차</th>
		<th>상환금</th>
		<th>원금</th>
		<th>이자</th>
		<th>잔액</th>
		</tr>
		<c:forEach var="loan" items="${list }">
			<tr>
				<td>${loan.idx }</td>
				<td>${loan.thisMonthOrigin }원</td>
				<td>${loan.thisMonthRate }원</td>
				<td>${loan.amount }원</td>
				<td>${loan.readyMonth }원</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>