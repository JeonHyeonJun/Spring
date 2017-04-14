<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>게시글 쓰기</h1><hr>
	<form action="insert.do" method="Post">
		<table>
		<tr><td style="background-color: yellow;">제목</td><td><input type="text" name="title"></td></tr>
		<tr><td style="background-color: yellow;">비밀번호</td><td><input type="text" name="pass"></td></tr>
		<tr><td style="background-color: yellow;">이메일</td><td><input type="text" name="email"></td></tr>
		<tr><td style="background-color: yellow;">파일첨부</td></tr>
		<tr><td style="background-color: yellow;">내용</td><td><textarea name="content" style="width: 500px; height: 300px"></textarea></td></tr>
		<tr><td colspan="2" align="right"><input type="submit" value="등록"></td></tr>
		</table>
	</form>
	</center>
</body>
</html>