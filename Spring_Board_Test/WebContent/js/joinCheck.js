function joinCheck() {	
	if ($('#id').val().replace(/ /gi, "") == "") {
		alert("아이디를 입력해주세요");
		$('#id').focus();
		return false;
	}
	if ($('#idCheck').text() == "중복") {
		alert("아이디가 이미 사용중입니다.");
		$('#id').focus();
		return false;
	}
	if ($('#pass').val().replace(/ /gi, "") == "") {
		alert("비밀번호를 입력해주세요");
		$('#pass').focus();
		return false;
	}
	if ($('#passCheck').text() != "사용가능") {
		alert("비밀번호 형식이 맞지않습니다.");
		$('#pass').focus();
		return false;
	}
	if ($('#pass2').val().replace(/ /gi, "") == "") {
		alert("비밀번호를 입력해주세요");
		$('#pass2').focus();
		return false;
	}
	if ($('#pass2Check').text() == "불일치") {
		alert("비밀번호가 일치하지 않습니다.");
		$('#pass2').focus();
		return false;
	}
	if ($('#name').val().replace(/ /gi, "") == "") {
		alert("닉네임을 입력해주세요");
		$('#name').focus();
		return false;
	}
	if ($('#nameCheck').text() == "중복") {
		alert("닉네임이 이미 사용중입니다.");
		$('#name').focus();
		return false;
	}
	return true;
}
