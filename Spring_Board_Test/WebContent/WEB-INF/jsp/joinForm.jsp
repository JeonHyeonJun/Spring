<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
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
	<center>
		<h1>회원가입</h1><hr>
		<form action="join.do" method="post">
			<table>
				<tr><td>아이디</td><td><input type="text" id="id" name="id"></td><td><span id="idCheck"></span></td></tr>
				<tr><td>비밀번호</td><td><input type="password" id="pass" name="pass"></td><td><span id="passCheck"></span></td></tr>
				<tr><td>비밀번호확인</td><td><input type="password" id="pass2" name="pass2"></td><td><span id="pass2Check"></span></td></tr>
				<tr><td>닉네임</td><td><input type="text" id="name" name="name"></td><td><span id="nameCheck"></span></td></tr>
				<tr><td></td><td><input type="submit" value="가입" onclick="return joinCheck()"><input type="button" value="돌아가기" onclick="location.href='main.do'"></td></tr>
			</table>
		</form>
	</center>
</body>
</html>