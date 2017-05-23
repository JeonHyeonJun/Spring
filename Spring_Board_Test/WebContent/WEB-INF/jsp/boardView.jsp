<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>게시글 상세보기</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-item.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	function reple(idx,repleIdx) {
  		var repleCount = ${fn:length(reple)};
  		for(var i=0; i<repleCount; i++){
  			$('#repleForm'+i).empty();
  			$('#repleContent'+i).html($('#repleContent'+i).text().replace(/</gi, "&lt;").replace(/>/gi, "&gt;"));
  			$('#updateForm'+i).show();
  		}
		$('#repleForm'+idx).html("<form action='repleWrite.do' method='post'>"
								 +"<textarea style='width: 85%; height: 100px; resize: none' id='content' name='content' maxlength='500'></textarea>"
								 +"<input type='submit' value='답글작성' class='btn btn-success'>"
								 +"<input type='hidden' name='boardIdx' value='${board.idx }'>"
								 +"<input type='hidden' name='writer' value='${sessionScope.name }'>"
								 +"<input type='hidden' name='writerIdx' value='${sessionScope.idx }'>"
								 +"<input type='hidden' name='parent' value='"+repleIdx+"'>"
								 +"</form>");
	}
	
	function update(idx,repleIdx){
  		var text = $('#repleContent'+idx).text();
  		var repleCount = ${fn:length(reple)};
  		for(var i=0; i<repleCount; i++){
  			$('#repleForm'+i).empty();
  			$('#repleContent'+i).html($('#repleContent'+i).text().replace(/</gi, "&lt;").replace(/>/gi, "&gt;"));
  			$('#updateForm'+i).show();
  		}
  		$('#updateForm'+idx).hide();
  		$('#repleContent'+idx).html("<form action='repleUpdate.do' method='post'>"
				 +"<textarea style='width: 85%; height: 100px; resize: none' id='repleContent' name='content' maxlength='500'>"+text+"</textarea>"
				 +"<input type='hidden' name='boardIdx' value='${board.idx }'>"
				 +"<input type='hidden' name='idx' value='"+repleIdx+"'>"
				 +"<input type='submit' value='수정' class='btn btn-success'>"
				 +"</form>")
  	}
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

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">첨부파일 다운로드</p>
                <div class="list-group">
                	<c:if test="${sessionScope.id != null }">
                    	<a href="download.do?fileId=${boardFile.fileId }" class="list-group-item active">${boardFile.originFileName }</a>
                    </c:if>
                    <c:if test="${sessionScope.id == null }">
                   		<a href="loginForm.do">첨부파일은 로그인 후 이용할수 있습니다.</a>
                    </c:if>
                </div>
            </div>

            <div class="col-md-9">

                <div class="thumbnail">
                    
                    <div class="caption-full">
                        <h2><a href="#">${board.title }</a></h2>
                        <h5 class="pull-right">${board.writeDate } |
                        <b>${board.writer }</b></h5><hr>
                        ${board.content }
                    </div>
                    <hr>
                    <div class="ratings">
                        <p class="pull-right">조회수 ${board.readCount }</p>
                        <p>
                            	댓글${fn:length(reple)}개
                        </p>
                    </div>
                </div>
                
				<center>
					<form action="boardDelete.do" method="post">
						<c:if test="${sessionScope.idx == board.writerIdx }">
							<input type="button" class="btn btn-success" value="게시글수정" onclick="location.href='boardUpdateForm.do?idx=${board.idx}'">
							<input type="hidden" id="idx" name="idx" value="${board.idx }">
							<input type="submit" class="btn btn-success" value="게시글삭제">
						</c:if>
						<input type="button" class="btn btn-success" value="돌아가기" onclick="location.href='main.do'">
					</form>
				</center>
                <div class="well">
					<form action="repleWrite.do" method="post">
						<input type="hidden" name="boardIdx" value="${board.idx }">
						<input type="hidden" name="writer" value="${sessionScope.name }">
						<input type="hidden" name="writerIdx" value="${sessionScope.idx }">
						<c:if test="${sessionScope.id == null }">
							<textarea id="content" name="content" readonly="readonly" style="width: 80%; height: 100px; resize: none;">로그인 후 이용해주세요</textarea>
						</c:if>
						<c:if test="${sessionScope.id != null }">
							<textarea id="content" name="content" style="width: 80%; height: 100px; resize: none;"></textarea>
							<input type="submit" class="btn btn-success" value="댓글쓰기">
						</c:if>
					</form>


                    <hr>

                   	<c:forEach items="${reple }" var="reple" varStatus="st">
	                    <div class="row">
	                        	<div class="col-md-12">
	                        	<c:if test="${reple.groupLv > 0 }">&nbsp;&nbsp;&nbsp;ㄴ</c:if>
	                            	<b>${reple.writer }</b>
	                            	<span class="pull-right">${reple.writeDate }</span>
	                            	| 
	                            	<c:if test="${reple.isDelete == 'N' }">
		                            	<span id="repleContent${st.index }"><!--  
										--><c:if test="${reple.parentName != null }"><!-- 
											--><b style="color: red;">@${reple.parentName }&nbsp;&nbsp;&nbsp;</b><!--
										--></c:if><!--
									-->${reple.content.replaceAll("<", "&lt;").replaceAll(">", "&gt;") }</span>
		                            	
		                            	<c:if test="${sessionScope.id != null }">
												<a href="##" onclick="reple(${st.index},${reple.idx })"><font size="1px">답글달기</font></a>
										</c:if>
										
		                            	<c:if test="${sessionScope.idx == reple.writerIdx }">
												<span id="updateForm${st.index }">
													<a href="##" onclick="update(${st.index},${reple.idx })"><font size="1px">수정</font></a>
													<a href="repleDelete.do?idx=${reple.idx }&boardIdx=${reple.boardIdx}"><font size="1px">삭제</font></a>
												</span>
										</c:if>
									</c:if>
									
									<c:if test="${reple.isDelete == 'Y' }">
										<font color="gray">삭제된 댓글입니다.</font>
									</c:if>
									
									<span id="repleForm${st.index }"></span>
	                        	</div>
	                    </div>
	                <hr>
                    </c:forEach>



                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Multicampus 2017</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
