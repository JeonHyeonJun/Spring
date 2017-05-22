<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글수정</title>
</head>
<body>
	<center>
		<h1>게시글수정</h1><hr>
		<form action="boardUpdate.do" method="post">
			<input type="hidden" id="idx" name="idx" value="${board.idx }"> 
			<input type="hidden" id="readCount" name="readCount" value="${board.readCount }">
			<table>
				<tr><td>제목</td><td colspan="2"><input type="text" id="title" name="title" value="${board.title }"></td></tr>
				<tr><td>사진</td><td colspan="2"><input type="file" id="ufile" name="ufile"></td></tr>
				<tr><td>내용</td><td colspan="2"><textarea id="content" name="content" style="resize: none; width: 500px; height: 500px">${board.content }</textarea></td></tr>
				<tr><td></td><td><input type="submit" value="수정하기"><input type="button" value="돌아가기" onclick="location.href='main.do'"></td>
			</table>
		</form>
	</center>
</body>
</html>