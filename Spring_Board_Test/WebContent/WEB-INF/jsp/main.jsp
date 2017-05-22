<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>
</head>
<body>
	<center>
		<h1>게시판</h1><hr>
	</center>
	
	<c:if test="${sessionScope.id == null}">
		<input type="button" value="회원가입" onclick="location.href='joinForm.do'">
		<input type="button" value="로그인" onclick="location.href='loginForm.do'"> 
	</c:if>
	
	<c:if test="${sessionScope.id != null }">
		${sessionScope.id }님 환영합니다!
		<input type="button" value="로그아웃" onclick="location.href='logout.do'"> 
	</c:if>
	
	<center>
		<table border="1" style="width: 80%; text-align: center" >
			<tr><th>글번호</th><th>제목</th><th>글쓴이</th><th>날짜</th><th>조회수</th></tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td width="10%">${board.idx }</td>
					<td width="50%"><a href="boardView.do?idx=${board.idx }">${board.title }</a></td>
					<td width="20%">${board.writer }</td>
					<td width="10%">${board.writeDate }</td>
					<td width="10%">${board.readCount }</td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${current != first }">
			<a href="main.do?page=${current-1 }">이전</a>
		</c:if>
		<c:forEach begin="${start }" end="${end }" var="page">
			<c:choose>
				<c:when test="${page == current }">
					<b>${page }</b>
				</c:when>
				<c:otherwise>
					<a href="main.do?page=${page }">${page }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${current != last }">
			<a href="main.do?page=${current+1 }">다음</a>
		</c:if>
				
		<c:if test="${sessionScope.id != null }">
			<input type="button" value="글쓰기" onclick="location.href='boardWriteForm.do'">
		</c:if>
	</center>

</body>
</html>