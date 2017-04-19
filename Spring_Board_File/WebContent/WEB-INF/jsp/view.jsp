<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1 style="background-image:url('dog.gif'); background-size: contain; ">게시글 보기</h1><hr>
		
		<table border="1" width="1000px" height="500px">
			<tr height="30px"><td width="100px" style= "background-color: yellow"><a href="download.do?id=${boardFile.id }">${boardFile.originFileName }</a>(${boardFile.size })</td><td align="right" colspan="3" style= "background-color: yellow">조회수 : ${board.readcount }</td></tr>
			<tr height="100px"><td align="center" style= "background-color: pink">제목</td><td colspan="3" style= "background-color: aqua"><h2>${board.title}</h2></td></tr>
			<tr height="100px"><td align="center" style= "background-color: pink">작성자</td><td style= "background-color: yellow"><b>${board.name}</b></td><td align="center" style= "background-color: pink">이메일</td><td style= "background-color: yellow"><b>${board.email }</b></td></tr>
			<tr><td align="center" style= "background-color: pink">내용</td><td colspan="3" style= "background-color: aqua"><h3>${board.content}</h3></td></tr>
		</table>
		
		<input type="button" value="수정" onclick="window.open('checkForm.do?command=updateForm&num=${board.num}', width=100, height=100);">
		<input type="button" value="삭제" onclick="window.open('checkForm.do?command=delete&num=${board.num}', width=100, height=100);">
		<input type="button" value="돌아갈래" onclick="location.href='list.do'">
	</center>
</body>
</html>