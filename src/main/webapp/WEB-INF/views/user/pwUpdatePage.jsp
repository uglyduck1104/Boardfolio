<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />

<script>
function pwUpdate(){
	var oldPw = document.pwForm.oldPw.value;	
	var newPw = document.pwForm.newPw.value;
	var normalRegExp = /^[a-zA-Z].{8,20}$/;
	var newPwConfirm = document.pwForm.newPwConfirm.value;
	if( newPw != newPwConfirm ){
		alert("변경할 비밀번호를 다시 확인해주세요.");
		document.pwForm.newPw.focus();
		return false;
	}
	if( !normalRegExp.test(newPw) ){
		alert("비밀번호는 최소한 8~20자 영문 대소문자를 조합해주세요.");
		return false;
	}
	return true;
}
</script>

<div class="user-main">
	<div class="title-wrap">
		<h2>비밀번호 변경</h2>
	</div>
	<form action="pw-update" name="pwForm" method="post" onsubmit="return pwUpdate();">
		<div class="cont-wrap">
			<p>변경할 비밀번호를 입력해 주세요.</p>
			<ul>
				<li>
					<input type="password" name="oldPw" placeholder="현재 비밀번호" maxlength="20" required/>
				</li>
				<li>
					<input type="password" name="newPw" placeholder="새로운 비밀번호" maxlength="20" required/>
				</li>
				<li>
					<input type="password" name="newPwConfirm" placeholder="새로운 비밀번호 확인" maxlength="20" required/>
				</li>
				<li>
					<input type="hidden" name="id" value="${sessionScope.mDto.id }" />
				</li>
			</ul>
		</div>
		<div class="cont-btn-wrap">
			<button type="submit">비밀번호 변경</button>
			<button type="button" onclick="location.href='/'">취소</button>
		</div>
	</form>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />