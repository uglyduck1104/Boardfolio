<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<script>
	function pwChk(f){
		var pw = f.newPw;
		var pwConfirm = f.newPwConfirm;
		var normalRegExp = /^[a-zA-Z].{8,20}$/;
		if( pw.value != pwConfirm.value ){
			alert("비밀번호를 다시 확인해주세요.");
			pw.focus();
			return false;
		}
		if( !normalRegExp.test(pw.value) ){
			alert("비밀번호는 최소한 8~20자 영문 대소문자를 조합해주세요.");
			return false;
		}
		return true;
	}
</script>
<div class="find-wrap">
	<div class="sub-title">
		<h1>비밀번호 변경</h1>
	</div>
	<form action="new-password" method="post" onsubmit="return pwChk(this);">
		<div class="find-form">
			<ul>
				<li>
					<input type="password" name="newPw" placeholder="새로 변경할 비밀번호" maxlength="20" required/>
				</li>
				<li>
					<input type="password" name="newPwConfirm" placeholder="새로 변경할 비밀번호 확인" maxlength="20" required/>
				</li>
			</ul>
			<div class="find-btn-wrap">
				<ul>
					<li><button type="submit">확인</button></li>
					<li>
						<input type="hidden" name="id" value=${id } />
						<input type="hidden" name="uuid" value=${uuid } />
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>