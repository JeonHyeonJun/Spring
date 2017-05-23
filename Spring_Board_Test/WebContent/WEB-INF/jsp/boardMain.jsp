<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>게시판메인</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/3-col-portfolio.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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

    <!-- Page Content -->
    <div class="container">

        <!-- Page Header -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">게시글 목록
                    <c:if test="${sessionScope.id != null }">
						<input type="button" class="btn btn-success" value="글쓰기" onclick="location.href='boardWriteForm.do'">
					</c:if>
					<c:if test="${sessionScope.id == null }">
						<small>로그인 후 글을 작성할수 있습니다.</small>
					</c:if>
                </h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- 게시글목록 -->
        <div class="row">
        	<c:forEach items="${boardList }" var="board">
	            <div class="col-md-4 portfolio-item" style="width: 350px; height: 300px">
	                <a href="boardView.do?idx=${board.idx }">
	                    	<img class="img-responsive" style="width: 100%; height: 60%;" src="imageShow/${board.fileId}.do" onerror="this.src='img/no_image.jpg'" alt="">
	                    

	                </a>
	                <h3>
	                    <a href="boardView.do?idx=${board.idx }">${board.title }</a>
	                </h3>
	                <p><b>${board.writer }</b></p><p>${board.writeDate } | 조회수 : ${board.readCount }</p>
	            </div>
            </c:forEach>
        </div>
        <!-- /.게시글목록 -->

        <hr>



        <!-- 페이징처리 -->
        <div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
	                <c:if test="${current != first }">
	                    <li>
	                        <a href="main.do?page=${current-1 }">&laquo;</a>
	                    </li>
	                </c:if>
	                
	               	<c:forEach begin="${start }" end="${end }" var="page">
						<c:choose>
							<c:when test="${page == current }">
								<li class="active"><a href="#">${page }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="main.do?page=${page }">${page }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

	                    
					<c:if test="${current != last }">
	                    <li>
	                        <a href="main.do?page=${current+1 }">&raquo;</a>
	                    </li>
	                </c:if>
                </ul>
            </div>
        </div>
        <!-- /페이징처리-->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Multicampus 2017</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
