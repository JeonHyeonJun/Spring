<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품추가</title>
</head>
<body>
	<center>
	<h1>상품추가</h1><hr>
	<form action="input.do">
		<table>
		<tr><td>상품명</td><td><input type="text" name="name"></td></tr>
		<tr><td>가격</td><td><input type="text" name="price"></td></tr>
		<tr><td>그림</td><td><input type="text" name="pictureurl"></td></tr>
		<tr><td>설명</td><td><input type="text" name="description"></td></tr>
		<tr><td><input type="submit" value="추가"></td></tr>
		</table>
	</form>
	</center>
</body>
</html>