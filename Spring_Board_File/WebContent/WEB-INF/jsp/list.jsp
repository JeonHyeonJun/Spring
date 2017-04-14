<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판Death</title>
</head>
<body>
	<center>
		<h1>게시판이다요</h1><hr>
		
		<table border="1">
			<tr><th width="100px">번호</th><th width="700px">제목</th><th width="200px">작성자</th><th width="100px">조회수</th><th width="100px">작성일</th></tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td align="center">${board.num }</td>
					<td><a href="view.do?num=${board.num }">${board.title }</a></td>
					<td align="center">${board.name }</td>
					<td align="center">${board.readcount }</td>
					<td align="center"><fmt:formatDate value="${board.writedate }" pattern="MM-dd"/></td>
				</tr>
			</c:forEach>
		</table>
			
				<c:if test="${start != first}">				
					<a href="list.do?page=${first }">[첫페이지]</a>
					<a href="list.do?page=${start-1 }">[이전]</a>
				</c:if>
			
			<c:forEach begin="${start }" end="${end }" var="page">
				<c:choose>
					<c:when test="${page == current }">
						${page }
					</c:when>
					<c:otherwise>				
						<a href="list.do?page=${page }">${page}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
				<c:if test="${end != last }">				
					<a href="list.do?page=${end+1}">[다음]</a>
					<a href="list.do?page=${last }">[마지막페이지]</a>
				</c:if>

		<br><img src="dog.gif" onclick="location.href='write.do'">
		<br>글쓰고싶으면 이미지를 클릭하세욥
	</center>
	
</body>
</html>