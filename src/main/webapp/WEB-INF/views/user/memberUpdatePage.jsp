<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<script>
var flag = "${flag}";
var isPwUpdate = "${isPwUpdate}";
if( flag == "1"){
	alert("비밀번호가 일치하지 않습니다.");
}
if( isPwUpdate == "NO" ){
	alert("현재 비밀번호가 일치하지 않습니다.");
} 
</script>
<div class="user-main">
	<div class="title-wrap">
		<h2>회원정보 수정</h2>
	</div>
	<form action="member-update-confirm" method="post">
		<div class="cont-wrap">
			<p>회원님의 소중한 정보를 안전하게 관리하세요.</p>
			<div>
				<p>회원정보를 수정하시려면 비밀번호를 입력하셔야 합니다.</p>
				<span>회원님의 개인정보 보호를 위한 본인 확인 절차이오니, 로그인 시 사용하시는 비밀번호를 입력해주세요.</span>
				<input type="hidden" name="confirmId" value=${ sessionScope.mDto.id } />
				<input type="password" name="confirmPw" placeholder="비밀번호를 입력해주세요." maxlength="20" required/>
			</div>
			<div class="cont-btn-wrap">
				<button type="button" onclick="history.back();">취소</button>
				<button type="submit" >확인</button>
			</div>
		</div>
	</form>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />