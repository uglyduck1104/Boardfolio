<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<jsp:include page="/WEB-INF/views/common/header.jsp" />


<div class="find-wrap">
	<div class="sub-title">
		<h1>회원 계정 찾기</h1>
	</div>
	<div class="find-form">
		<form method="post" action="find-account">
			<h3>이메일 주소를 입력해주세요.</h3>
			<ul>
				<li>
					<p>회원 가입시 입력하신 이메일 주소를 입력하시면,</p>
					<p>해당 이메일로 아이디 및 비밀번호</p>
				</li>
				<li>
					<input type="text" name="email" placeholder="test@test.com" autocomplete="off" />
				</li>
			</ul>
			<div class="find-btn-wrap">
				<ul>
					<li>
						<button type="button">계정 찾기</button>
					</li>
					<li>
						<button type="button" onclick="location.href='login-form'">로그인 하기</button>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="resources/js/login.js" ></script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %> 