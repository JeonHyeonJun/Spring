<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글수정</title>
  <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
  <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.3/summernote.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.3/summernote.js"></script>
<script type="text/javascript" src="js/boardCheck.js"></script>
<script type="text/javascript">  
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 500,
			callbacks: {
				onImageUpload: function(files, editor, welEditable) {
					for (var i = files.length - 1; i >= 0; i--) {
						sendFile(files[i],  editor, welEditable);
					}
				}
			}
		});
		
		$('#write').click(function() {
			var content = $('#summernote').summernote('code');
			$('#content').val(content);
		});
	});
</script>
</head>
<body>
<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="main.do">Spring Board</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                	<c:if test="${sessionScope.id != null }">
	                    <li>
	                        <a href="logout.do">로그아웃</a>
	                    </li>
                    </c:if>
                    <c:if test="${sessionScope.id == null }">
	                    <li>
	                        <a href="joinForm.do">회원가입</a>
	                    </li>
	                    <li>
	                        <a href="loginForm.do">로그인</a>
	                    </li>
                    </c:if>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
	<center>
		<h4>게시글수정</h4><hr>
		<form action="boardUpdate.do" method="post" enctype="multipart/form-data">
			<input type="hidden" id="content" name="content">
			<input type="hidden" id="idx" name="idx" value="${board.idx }"> 
			<input type="hidden" id="readCount" name="readCount" value="${board.readCount }">
			<table width="80%">
				<tr><td>제목</td><td colspan="2"><input type="text" id="title" name="title" maxlength="20" value="${board.title }"></td></tr>
				<tr><td>첨부파일</td><td colspan="2"><input type="file" class="btn btn-success" id="ufile" name="ufile"></td></tr>
				<tr><td>내용</td><td colspan="2"><div id="summernote">${board.content }</div></td></tr>
				<tr><td></td><td><input type="submit" class="btn btn-success" id="write" value="수정하기" onclick="return boardCheck()"><input type="button" class="btn btn-success" value="돌아가기" onclick="location.href='main.do'"></td>
			</table>
		</form>
	</center>
</body>
</html>