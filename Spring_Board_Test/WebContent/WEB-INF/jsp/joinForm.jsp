<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>게시글 상세보기</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-item.css" rel="stylesheet">
<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="js/joinCheck.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var regId =  /^.*(?=^.{6,20}$)(?=.*[a-z]).*$/;
		var regPassword = /^.*(?=^.{6,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[*!@#$%^&+=]).*$/;
		
		$('#id').keyup(function(){
			if(!regId.test($('#id').val())){
				$('#idCheck').html('<font color="red">소문자 또는 소문자+숫자 6~20자</font>');
			}else{
				var inputid = $('#id').val();
 				$.ajax({ 
 			 	    url : "idCheck.do",
 			    	type : 'GET',
  			     	data : 'id=' + inputid,
   			     	dataType: 'json',
	   			    success : function (data) {
 	   			        if(data.result){
    			     		$('#idCheck').html('<font color="green">사용가능</font>');
 	   			        }
 	   			        else {
 	   			        	$('#idCheck').html('<font color="red">중복</font>');
 	   			        }
	   			    },
   			     	error : function(){
   			    		alert('id오류');
   			     	}
   			 	});
			}

				
		});
		
	    $('#pass').keyup(function(){
	    	if( $('#pass').val() != ""){
				if(!regPassword.test($('#pass').val())){
					$('#passCheck').html('<font color="red">대소문자, 숫자, 특수문자를 혼합하여 6~20자 이내</font>');
					
				}else {
					$('#passCheck').html('<font color="green">사용가능</font>');
					if($('#pass2').val() != "")
						checkPass();
				}
	    	}
		});
			
			$('#pass2').keyup(function(){
				if($('#pass2').val() != "")
					checkPass();
			});
			
			
		var checkPass = function() {
			if($('#pass').val() != $('#pass2').val()){
  				$('#pass2Check').html('<font color="red">불일치</font>');
  			}else {
  				$('#pass2Check').html('<font color="green">일치</font>');
  			}
		};
		
		$('#name').keyup(function(){
			if($('#name').val() != ''){
			var inputname = $('#name').val();
			 $.ajax({
				url : "nameCheck.do",
				type : "GET",
				data : 'name=' + inputname,
				dataType : 'json',
				success : function (data){
					if(data.result){
						$('#nameCheck').html('<font color="green">사용가능</font>');
					}
					else{
						$('#nameCheck').html('<font color="red">중복</font>');
					}
				},
				error : function(){
					alert('에러발생');
				}
			}); 
			}
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
    
    <div class="container">
    	<div class="row">
    		<center>
				<h1 class="page-header">회원가입</h1>
				<form action="join.do" method="post">
					  <div class="col-xs-4" style="left: 35%">
		    			<input type="text" id="id" name="id" class="form-control" placeholder="아이디"><span id="idCheck"></span>
		  			  </div>
		  			  <br><br><br><br>
		  			  <div class="col-xs-4" style="left: 35%">
		    			<input type="password" id="pass" name="pass" class="form-control" placeholder="비밀번호"><span id="passCheck"></span>
		  			  </div>
		  			  <br><br><br><br>
		  			  <div class="col-xs-4" style="left: 35%">
		    			<input type="password" id="pass2" name="pass2" class="form-control" placeholder="비밀번호확인"><span id="pass2Check"></span>
		  			  </div>
		  			  <br><br><br><br>
		  			  <div class="col-xs-4" style="left: 35%">
		    			<input type="text" id="name" name="name" class="form-control" placeholder="닉네임"><span id="nameCheck"></span>
		  			  </div>
		  			  <br><br><br><br>
		  			  <input type="submit" class="btn btn-success" value="가입" onclick="return joinCheck()">
		  			  <input type="button" class="btn btn-success" value="돌아가기" onclick="location.href='main.do'">
					
				</form>
			</center>
		</div>
	</div>
	
	    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>