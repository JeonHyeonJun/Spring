<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>히어로즈오브더스톰</title>
<script type="text/javascript">
	window.onload = function() {
		
	}
</script>
</head>
<body>
	<center>
		<h1>히어로즈오브더스톰</h1><hr>
		<c:choose>
			<c:when test="${id == null }">
				<img src="img/hos.gif" width="200px" height="200px"><br>
				<input type="button" value="회원가입" onclick="location.href='createForm.do'">
				<input type="button" value="로그인" onclick="location.href='loginForm.do'">
			</c:when>
			<c:otherwise>
				게시판으로 이동<br>
				<a href="list.do"><img src="img/good.jpg"><br></a>
				<input type="button" value="로그아웃" onclick="location.href='logout.do'"> 
				<input type="button" value="비번변경" onclick="alert('만들려다가 귀찮아져서 관둠')">
				<input type="button" value="회원탈퇴" onclick="alert('히히히 못가')">
			</c:otherwise>
		</c:choose>
	</center>
</body>
</html>