<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>노케이 저축은행</title>
</head>
<body>
	<h3>돈갚으셔야죠^^</h3>
	<form action="result.do">
	대출금 <input type="text" name="amount"><br>
	대출금리 <input type="text" name="rate"><br>
	상환개월수 <input type="text" name="period"><br>
	대출유형  <input type="radio" name="type" value="1">원리금균등상환
	<input type="radio" name="type" value="2">원금균등상환<br>
	<input type="submit" value="계산">
	<input type="reset" value="안해">
	</form>
</body>
</html>