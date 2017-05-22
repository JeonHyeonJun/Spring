<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글작성</title>
</head>
<body>
	<center>
		<h1>게시글작성</h1><hr>
		<form action="boardWrite.do" method="post" enctype="multipart/form-data">
			<input type="hidden" id="writer" name="writer" value="${sessionScope.name }">
			<input type="hidden" id="writerIdx" name="writerIdx" value="${sessionScope.idx }">
			<table>
				<tr><td>제목</td><td colspan="2"><input type="text" id="title" name="title"></td></tr>
				<tr><td>첨부파일</td><td colspan="2"><input type="file" id="ufile" name="ufile"></td></tr>
				<tr><td>내용</td><td colspan="2"><textarea id="content" name="content" style="resize: none; width: 500px; height: 500px"></textarea></td></tr>
				<tr><td></td><td><input type="submit" value="글쓰기"><input type="button" value="돌아가기" onclick="location.href='main.do'"></td>
			</table>
		</form>
	</center>
</body>
</html>