<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
   <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-item.css" rel="stylesheet">
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
		<h1>로그인</h1><hr>
		<form action="login.do" method="post">
			<div class="col-xs-4" style="left: 35%">
		    	<input type="text" id="id" name="id" class="form-control" placeholder="아이디"><span id="idCheck"></span>
		  	</div>
		  	<br><br><br><br>
		  	<div class="col-xs-4" style="left: 35%">
		    	<input type="password" id="pass" name="pass" class="form-control" placeholder="비밀번호"><span id="passCheck"></span>
		  	</div>
		  	<br><br><br><br>
		  	<input type="submit" class="btn btn-success" value="로그인">
		  	<input type="button" class="btn btn-success" value="돌아가기" onclick="location.href='main.do'">
		</form>
	</center>
	
		    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>