<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품리스트</title>
</head>
<body>
	<center>
		<h1>상품 리스트</h1>
		<hr>
		<form action="search.do">
		<select name="type">
			<option value="1">이름</option>
			<option value="2">코드</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
		<input type="button" value="추가" name="input" onclick="location.href='jsp/input.jsp'"></button>
		</form>
		
		<table border="1">
			<tr>
				<th>상품코드</th><th>상품명</th><th>가격</th><th>경로</th><th>설명</th><th>가격수정</th><th></th>
			</tr>
			<c:forEach items="${list }" var="product">
				<tr>
					<td>${product.code }</td>
					<td>${product.name }</td>
					<td>${product.price }</td>
					<td>${product.pictureurl }</td>
					<td>${product.description }</td>
					<td><form action="update.do">
					<input type="text" name="price">
					<input type="hidden" name = "code" value="${product.code }">
					<input  type="submit" value="수정"> 
					</form>
					</td>
					<td><form action="suicide.do">
					<input type="hidden" name = "code" value="${product.code }">
					<input  type="submit" value="자살"> 
					</form></td>
				</tr>
			</c:forEach>
		</table>
		<img src="main.jpeg" width="500px" height="500px">
	</center>
</body>
</html>