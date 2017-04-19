<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<!-- CSS영역 -->
<style type="text/css">
*{
padding-left:30px;
}

.form-control{
	width: 50%;
	display: inline-block;
}
.span{
	color:red;
	font-size: 20px;
	padding-left:5px;
		
}
h1{
padding-left: 130px;
}
</style>

<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$('#id').blur(function() {
			var inputid = $('#id').val();
			$.ajax({
				//get인지 post인지,
				type : 'get',
				//어디로 보낼건지,
				url : 'idCheck.do',
				//응답받는 데이터 타입
				dataType : 'json',
				//파라미터가 있다면 파라미터
				data : 'id='+inputid,
				//성공 시 수행할 동작
				success : function(data){
					if(data.result){
						$('#idcheck').text("사용가능");
					}
					else{
						$('#idcheck').text("중복");
					}
						
				},
				//실패시 수행할 동작
				error : function(xhrReq, status, error){
					alert(error);	//error의 원인을 알려줌. 근데 암것도 안뜨네?
					alert("실패");
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="container">

		<div class="row">
			<h1>회원 가입</h1>
		</div>
		<hr>

		<div class="row">
			<form action="create.do" class="form-horizontal" id="result">
				<div class="form-group">
					<label for="id" class="col-sm-2 control-label">ID</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="id" name="id"
							placeholder="ID를 입력하세요"> <span class="span" id="idcheck">ID중복여부</span>
					</div>
				</div>
				<div class="form-group">
					<label for="pass" class="col-sm-2 control-label">PASSWORD</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="pw" name="pw"
							placeholder="PASSWORD를 입력하세요"> <span class="span" id="passcheck"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="pass_ok" class="col-sm-2 control-label">PASSWORD_RE</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="pass_ok" name="pass_ok"
							placeholder="한번더 PASSWORD를 입력하세요"> <span class="span" id="pass_okcheck"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">NAME</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="Name을 입력하세요"> <span class="span" id="emailcheck"></span>
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary" id="ok">확인</button>
						<button type="reset" class="btn btn-danger">취소</button>
					</div>
				</div>
			</form>
		</div>


	</div>
</body>
</html>