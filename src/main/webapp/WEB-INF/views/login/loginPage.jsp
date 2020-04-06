<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<script type="text/javascript">
var userJoin = "${userJoin}";
if( userJoin == "SUCCESS" ){
	alert("회원가입이 완료되었습니다.");
} 
if( userJoin == "FAIL" ){ 
	alert("회원가입이 실패했습니다.");
	history.back();
}
</script>

<div class="login-wrap">
	<form action="login-user" method="post">
		<div class="duck-ico">
			<img alt="duck-icon" src="./resources/images/login-duck-icon.png" />
		</div>
		<div class="sub-title">
			<h1>회원 로그인</h1>
		</div>
		<div class="login-form">
			<ul>
				<li><input type="text" name="id" placeholder="아이디" /></li>
				<li><input type="password" name="pw" placeholder="비밀번호" /></li>
			</ul>
		</div>		
		<div class="submit-form">
			<ul>
				<li><button type="submit" class="btn">로그인</button></li>
			</ul>
		</div>	
	</form>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %> 