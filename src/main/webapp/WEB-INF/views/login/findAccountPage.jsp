<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<script>
var isEmailConfirm = "${isEmailConfirm}";
if( isEmailConfirm == "NO" ){
	alert("해당 정보와 일치하는 이메일이 없습니다.");
}
</script>

<div class="find-wrap">
	<div class="sub-title">
		<h1>회원 계정 찾기</h1>
	</div>
	<div class="find-form">
		<form:form method="post" action="find-account" modelAttribute="memberDto">
			<h3>이메일 주소를 입력해주세요.</h3>
			<ul>
				<li>
					<p>회원 가입시 입력하신 이메일 주소를 입력하시면,</p>
					<p>해당 이메일로 아이디 및 비밀번호 변경링크를 보드립니다.</p>
				</li>
				<li>
					<form:input path="email" name="email" placeholder="this@form.com" />
					<form:errors path="email" cssClass="error-msg" element="p"/>
				</li>
			</ul>
			<div class="find-btn-wrap">
				<ul>
					<li>
						<button type="submit">계정 찾기</button>
					</li>
					<li>
						<button type="button" onclick="location.href='login-form'">로그인 하기</button>
					</li>
				</ul>
			</div>
		</form:form>
	</div>
</div>
<script type="text/javascript" src="resources/js/login.js" ></script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %> 