$(function(){
	$(document).on("click", "#write-btn", function(){
		if( $("input[name='title']").val() == "" ){
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		if( $("input[name='content']").val() == ""){
			alert("내용을 입력해주세요.");
			$("#content").focus();
			return false;
		}
	});
});