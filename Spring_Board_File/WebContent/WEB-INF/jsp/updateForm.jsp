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
	<form action="update.do" method="Post">
		<input type="hidden" name="num" value="${board.num }">
		<input type="hidden" name="readcount" value="${board.readcount }">
		<table>
		<tr><td>제목</td><td><input type="text" name="title" value="${board.title }"></td></tr>
		<tr><td>비밀번호</td><td><input type="text" name="pass" value="${board.pass }"></td></tr>
		<tr><td>이메일</td><td><input type="text" name="email" value="${board.email }"></td></tr>
		<tr><td>파일첨부</td></tr>
		<tr><td>내용</td><td><input type="text" name="content" value="${board.content }"></td></tr>
		<tr><td><input type="submit" value="등록"></td></tr>
		</table>
	</form>
	</center>
</body>
</html>