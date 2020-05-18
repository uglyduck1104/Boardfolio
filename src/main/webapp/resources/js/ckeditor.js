CKEDITOR.replace('contents',{
	filebrowserUploadUrl: "file-upload"
});
function formSubmit(){
	var title = document.formField.title;
	var contents = CKEDITOR.instances.contents.getData();
	if (title.value == ""){
		alert("제목을 입력해주세요.");
		title.focus();
		return false;
	}
	if(contents == "" || contents == 0){
		alert("내용을 입력해주세요.");
		return false;
	}
	return true;
}


