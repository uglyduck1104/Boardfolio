<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="/WEB-INF/views/common/header.jsp" />


<div class="join-wrap">
	<form:form action="add-member" method="POST" modelAttribute="memberDto">
		<div class="duck-ico">
			<img alt="duck-icon" src="./resources/images/login-duck-icon.png" />
		</div>
		<div class="sub-title">
			<h1>회원가입</h1>
		</div>
		<div class="join-form">
			<ul>
				<li>
					<form:input path="id" placeholder="아이디" />
					<form:errors path="id" cssClass="error-msg" element="li"/>
					<div id="ico-checked" class="ico-status" ></div>
				</li>
				<li>
					<form:password path="pw" placeholder="비밀번호" />
					<form:errors path="pw" cssClass="error-msg" element="li"/>
					<div id="pwd-ico" class="pwd-status" ></div>
				</li>
				<li>
					<form:input path="name" placeholder="이름" />
					<form:errors path="name" cssClass="error-msg" element="li"/>
				</li>
				<li>
					<form:input path="nickname" placeholder="닉네임" />
					<form:errors path="nickname" cssClass="error-msg" element="li"/>
				</li>
				<li>
					<form:input path="email" placeholder="이메일" />
					<form:errors path="email" cssClass="error-msg" element="li"/>
				</li>
			</ul>
		</div>		
		<div class="submit-form">
			<ul>
				<li><button type="submit" class="btn" id="submit-btn">가입하기</button></li>
			</ul>
		</div>	
	</form:form>
</div>
<script type="text/javascript" src="resources/js/join.js" ></script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %> 