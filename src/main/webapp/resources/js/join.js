$(function(){
	/*
	 * 비밀번호 
	 * 	safeRegExp : 8~20자 영문 대문자 + 소문자 + 숫자 + 언더스코어를 제외한 특수문자를 조합  
	 * 	normalRegExp : 8~20자 영문 대소문자 + 숫자 혹은 특수문자를 조합
	 *  dangerRegExp : 8~20자 영문 대소문자
	 */
	var safeRegExp = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?=.*\d).{8,20}$/); // 권장
	var normalRegExp = RegExp(/^([a-zA-Z0-9]{8,20})\w$/); 	// 보통
	var dangerRegExp = RegExp(/^([a-zA-Z]{8,20})\w$/); 	// 위험
	
	// 중복체크 여부
	var checked = false;
	$("#ico-checked").click(function(){
		if( $("#id").val()!="" ){
			$.ajax({
				url: "id-check",
				type: "POST",
				data: {
					"id" : $("#id").val()
				},
				success: function( obj ){
					console.log(obj);
					if( obj["isValid"] == "TRUE" ){
						alert("중복되지 않은 아이디입니다.");
						$("#ico-checked").attr("class", "ico-true");
						$("#ico-checked").css("background-position", "-121px -24px");
						checked = true;
					} else {
						alert("중복된 아이디입니다.");
						$("#ico-checked").attr("class", "ico-false");
						$("#ico-checked").css("background-position", "-69px -24px");
						checked = false;
					}
				},
				error: function(){
					alert("아이디 검증 실패");
				}
			});
		}else{
			alert("아이디 입력 후 중복 체크 해주세요!");
		};
	});
	$("#pw").keyup(function(){
		if( safeRegExp.test($(this).val()) ){
			$("#pwd-ico").attr("class", "pwd-high");
			$("#pwd-ico").css("background-position", "-170px -17px");
		}
		if( normalRegExp.test($(this).val()) ){
			$("#pwd-ico").attr("class", "pwd-normal");
			$("#pwd-ico").css("background-position", "-308px -17px");
		}
		if( dangerRegExp.test($(this).val()) ){
			$("#pwd-ico").attr("class", "pwd-low");
			$("#pwd-ico").css("background-position", "-215px -17px");
		}
	});
	$("#submit-btn").click(function(){
		if ( !checked ){
			alert("아이디 중복여부를 확인해주세요.");
			return false;
		} else {
			return true;
		}
	});
	
	// Form 영역 입력 길이 제한
	$("input[type=text], input[type=password]").each(function(){
		$(this).attr("maxlength", "20");
	});
});