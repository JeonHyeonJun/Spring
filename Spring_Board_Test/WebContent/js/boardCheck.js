function boardCheck() {	
	if ($('#title').val().replace(/ /gi, "") == "") {
		alert("제목을 입력해주세요");
		$('#title').focus();
		return false;
	}
	var content = $('#summernote').summernote('code');
	$('#content').val(content);
	if (content == "<p><br></p>") {
		alert("내용을 입력해주세요");
		return false;
	}
	return true;
}


function sendFile(file, editor, welEditable) {
    var form_data = new FormData();
    form_data.append('file', file);
    $.ajax({
      data: form_data,
      type: "POST",
      url: 'image.do',
      cache: false,
      contentType: false,
      enctype: 'multipart/form-data',
      processData: false,
      success: function(data) {
        $('#summernote').summernote('insertImage', "imageShow/"+data.fileId+".do");
      },
	  error : function(xhrReq, status, error){
		alert("실패");
	  }
    });
  }