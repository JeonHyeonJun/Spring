<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<center>
		<h1>로그인</h1><hr>
		<form action="login.do" method="post">
			<table>
				<tr><td>아이디</td><td><input type="text" id="id" name="id"></td></tr>
				<tr><td>비밀번호</td><td><input type="password" id="pass" name="pass"></td></tr>
				<tr><td></td><td><input type="submit" value="로그인"><input type="button" value="돌아가기" onclick="location.href='main.do'"></td></tr>
			</table>
		</form>
	</center>
</body>
</html>