<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<script type="text/javascript">
var isJoin = "${isJoin}";
if( isJoin == "YES" ){
	var isJoinRes = "${isJoinRes}";
	if( isJoinRes > 0 ){
		alert("회원가입이 완료되었습니다.");
	} else {
		alert("회원가입이 실패했습니다.");
	}
} 
var failure = "${failure}";
if( failure == "noneId" ){
	alert("일치하는 아이디가 없습니다.");
} else if ( failure == "missMatchIdPw" ){
	alert("아이디 패스워드가 일치하지 않습니다.");
} else if ( failure == "withDrawId" ){
	alert("탈퇴 처리된 계정입니다.");
}

var isMemberUpdate = "${isMemberUpdate}";
if( isMemberUpdate == "YES" ){
	var isMemberUpdateRes = "${isMemberUpdateRes}";
	if( isMemberUpdateRes > 0){
		alert("회원 정보가 변경되었습니다. 회원 정보 반영을 위해 다시 로그인해주세요.");
	} else {
		alert("회원 정보 변경이 실패했습니다. 관리자에게 문의하세요.");
	}
}

var isPwUpdate = "${isPwUpdate}";
if( isPwUpdate == "YES" ){
	var isPwUpdateRes = "${isPwUpdateRes}";
	if( isPwUpdateRes > 0){
		alert("비밀번호가 변경되었습니다. 다시 로그인해주세요.");
	} else {
		alert("비밀번호가 변경이 실패했습니다. 관리자에게 문의하세요.");
	}
}
</script>

<div class="login-form-wrap">
	<form id="login-form" action="login" method="post" onsubmit="return formChk(this);">
		<div class="duck-ico">
			<img alt="duck-icon" src="./resources/images/login-duck-icon.png" />
		</div>
		<div class="sub-title">
			<h1>회원 로그인</h1>
		</div>
		<div class="login-wrap">
			<c:choose>
				<c:when test="${ cookie.id ne null }">	
					<ul>
						<li><input type="text" name="id" value="${ cookie.id.getValue() }" placeholder="아이디" /></li>
						<li><input type="password" name="pw" placeholder="비밀번호" /></li>
					</ul>
				</c:when>
				<c:otherwise>	
					<ul>
						<li><input type="text" name="id" placeholder="아이디" /></li>
						<li><input type="password" name="pw" placeholder="비밀번호" /></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>		
		<div class="check-wrap">
			<div class="chk-area">
				<input type="checkbox" name="isChecked" id="isChecked" checked/>
				<label for="isChecked">
					<span class="txt">아이디 저장</span>
				</label> 
			</div>
			<div class="find-area">
				<a href="find-account-page">계정 찾기</a>
			</div>
		</div>
		<div class="submit-wrap">
			<ul>
				<li><button type="submit" class="btn">로그인</button></li>
			</ul>
		</div>	
	</form>
</div>
<script type="text/javascript" src="resources/js/login.js" ></script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %> 