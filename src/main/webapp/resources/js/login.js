$(function(){
	$("#login-form .btn").click(function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
		if($("#pw").val() == ""){
			alert("비밀번호를 입력해주세요.");
			$("#pw").focus();
			return false;
		}
		$("#login-form").attr("action", "login").submit();
	});
});


