<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<center>
		<h1>게시글수정</h1><hr>
		<form action="boardUpdate.do" method="post" enctype="multipart/form-data">
			<input type="hidden" id="content" name="content">
			<input type="hidden" id="idx" name="idx" value="${board.idx }"> 
			<input type="hidden" id="readCount" name="readCount" value="${board.readCount }">
			<table width="80%">
				<tr><td>제목</td><td colspan="2"><input type="text" id="title" name="title" maxlength="20" value="${board.title }"></td></tr>
				<tr><td>첨부파일</td><td colspan="2"><input type="file" id="ufile" name="ufile"></td></tr>
				<tr><td>내용</td><td colspan="2"><div id="summernote">${board.content }</div></td></tr>
				<tr><td></td><td><input type="submit" id="write" value="수정하기" onclick="return boardCheck()"><input type="button" value="돌아가기" onclick="location.href='main.do'"></td>
			</table>
		</form>
	</center>
</body>
</html>