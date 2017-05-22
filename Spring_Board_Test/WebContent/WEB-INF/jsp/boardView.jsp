<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글상세보기</title>
<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	function reple(idx,repleIdx) {
  		var repleCount = ${fn:length(reple)};
  		for(var i=0; i<repleCount; i++){
  			$('#repleForm'+i).empty();
  		}
		$('#repleForm'+idx).html("<form action='repleWrite.do' method='post'>"
								 +"<textarea style='width: 85%; height: 100px; resize: none' id='content' name='content' maxlength='500'></textarea>"
								 +"<input type='submit' value='답글작성'>"
								 +"<input type='hidden' name='boardIdx' value='${board.idx }'>"
								 +"<input type='hidden' name='writer' value='${sessionScope.name }'>"
								 +"<input type='hidden' name='writerIdx' value='${sessionScope.idx }'>"
								 +"<input type='hidden' name='parent' value='"+repleIdx+"'>"
								 +"</form>");
	}
</script>
</head>
<body>
	<center>
		<h1>게시글상세보기</h1><hr>
			<table border="1" width="80%" height="700px">
				<tr><td colspan="4" align="right">조회수 : ${board.readCount }</td></tr>
				<tr height="10%"><td align="center" width="10%">제목</td><td  width="50%">${board.title.replaceAll("<", "&lt;").replaceAll(">", "&gt;") }</td><td width="10%">글쓴이</td><td  width="30%">${board.writer }</td></tr>
				<tr height="10%"><td align="center">사진</td><td colspan="3"></td></tr>
				<tr height="80%"><td align="center">내용</td><td colspan="3">${board.content.replaceAll("<", "&lt;").replaceAll(">", "&gt;") }</td></tr>
			</table>
			
				
			<form action="boardDelete.do" method="post">
				<c:if test="${sessionScope.idx == board.writerIdx }">
					<input type="button" value="수정" onclick="location.href='boardUpdateForm.do?idx=${board.idx}'">
					<input type="hidden" id="idx" name="idx" value="${board.idx }">
					<input type="submit" value="삭제">
				</c:if>
				<input type="button" value="돌아가기" onclick="location.href='main.do'">
			</form>
			
			

				<table width="80%" style="background-color: lightgray">
					<c:forEach items="${reple }" var="reple" varStatus="st">
						<tr>
							<td width="10%">
								<c:if test="${reple.groupLv > 0 }">&nbsp;&nbsp;&nbsp;ㄴ</c:if>
								<b>${reple.writer }</b>
							</td>
							<td width="80%">
								|
								<c:if test="${reple.parentName != null }">
									<b style="color: red;">@${reple.parentName }&nbsp;&nbsp;&nbsp;</b>
								</c:if>
								${reple.content }
								<c:if test="${sessionScope.id != null }">
									<a href="##" onclick="reple(${st.index},${reple.idx })"><font size="1px">답글달기</font></a>
								</c:if>
							</td>
							<td width="10%">${reple.writeDate }</td>
						</tr>
						<tr>
							<td colspan="3"><span id="repleForm${st.index }"></span></td>
						</tr>						
					</c:forEach>
					</table>
					<div>
						<form action="repleWrite.do" method="post">
							<input type="hidden" name="boardIdx" value="${board.idx }">
							<input type="hidden" name="writer" value="${sessionScope.name }">
							<input type="hidden" name="writerIdx" value="${sessionScope.idx }">
								<c:if test="${sessionScope.id == null }">
									<textarea id="content" name="content" readonly="readonly" style="width: 70%; resize: none;">로그인 후 이용해주세요</textarea>
								</c:if>
								<c:if test="${sessionScope.id != null }">
									<textarea id="content" name="content" style="width: 70%; resize: none;"></textarea>
								</c:if>
							<input type="submit" value="댓글쓰기">
						</form>
					</div>
			
			
	</center>
</body>
</html>