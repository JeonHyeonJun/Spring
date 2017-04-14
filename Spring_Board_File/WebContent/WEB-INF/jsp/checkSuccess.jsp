<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		if(${command == "delete"}){
			alert("삭제완료");
			window.opener.parent.location.href = "list.do";			
		}
		else if(${command == "update"}){
			window.opener.parent.location.href = "updatePage.do?num=${board.num}";	
		}
		window.close();
	</script>
</body>
</html>