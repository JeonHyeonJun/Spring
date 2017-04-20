<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="position:absolute; width: 100%; height: 20%; background-color: blue">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div style="position:absolute; top: 20%; width: 20%; height: 60%; background-color: red">
		<tiles:insertAttribute name="left"></tiles:insertAttribute>
	</div>
	<div style="position:absolute; top: 20%; left: 20%; width: 80%; height: 60%; background-color: pink">
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</div>
	<div style="position:absolute; top: 80%; width: 100%; height: 20%; background-color: gray">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>