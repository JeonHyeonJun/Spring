<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<center>
		<h1>회원가입</h1><hr>
		<form action="join.do" method="post">
			<table>
				<tr><td>아이디</td><td><input type="text" id="id" name="id"></td></tr>
				<tr><td>비밀번호</td><td><input type="password" id="pass" name="pass"></td></tr>
				<tr><td>비밀번호확인</td><td><input type="password" id="pass2" name="pass2"></td></tr>
				<tr><td>닉네임</td><td><input type="text" id="name" name="name"></td></tr>
				<tr><td></td><td><input type="submit" value="가입"><input type="button" value="돌아가기" onclick="location.href='main.do'"></td></tr>
			</table>
		</form>
	</center>
</body>
</html>