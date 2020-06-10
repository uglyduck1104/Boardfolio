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
	<div class="cont-title">
		<h2>비밀번호 변경</h2>
	</div>
	<form action="pw-update" name="pwForm" method="post" onsubmit="return pwUpdate();">
		<div class="cont-wrap">
			<h3>변경할 비밀번호를 입력해 주세요.</h3>
			<div class="cont-info">
				<ul class="cont-middle">
					<li>
						<label for="curPw">현재 비밀번호</label>
						<input type="password" name="oldPw" id="curPw" maxlength="20" required/>
					</li>
					<li>
						<label for="newPw">새 비밀번호</label>
						<input type="password" name="newPw" id="newPw" maxlength="20" required/>
					</li>
					<li>
						<label for="newPwCon">새 비밀번호 확인</label>
						<input type="password" name="newPwConfirm" id="newPwCon" maxlength="20" required/>
					</li>
					<li>
						<input type="hidden" name="id" value="${sessionScope.mDto.id }" />
						<button type="submit">비밀번호 변경</button>
						<button type="button" onclick="location.href='/'">취소</button>
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />