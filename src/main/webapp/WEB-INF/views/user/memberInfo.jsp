<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<script>
function pwUpdatePage(){
	location.href="pw-update-page";
}
function memberDrop(){
	if(confirm("회원을 탈퇴하시겠습니까?")){
		location.href="member-drop";
	}
}
</script>
<div class="user-main">
	<div class="title-wrap">
		<h2>회원정보 수정</h2>
	</div>
	<form:form action="member-update" method="post" modelAttribute="memberDto">
		<div class="cont-wrap">
			<ul>
				<li>
					<form:input path="name" value="${ mDto.name }" placeholder="이름" />
					<form:errors path="name" cssClass="error-msg" element="li"/>
				</li>
				<li>
					<form:input path="nickname" value="${ mDto.nickname }" placeholder="닉네임" />
					<form:errors path="nickname" cssClass="error-msg" element="li"/>
				</li>
				<li>
					<form:input path="email" value="${ mDto.email }" placeholder="이메일" />
					<form:errors path="email" cssClass="error-msg" element="li"/>
				</li>
				<li>
					<input type="hidden" name="id" value="${sessionScope.mDto.id }" />
					<input type="hidden" name="pw" value="${sessionScope.mDto.pw }" />
					<button type="submit">정보 수정</button>
				</li>
			</ul>
		</div>
		<div class="cont-btn-wrap">
			<button type="button" onclick="pwUpdatePage()">비밀번호 변경</button>
			<button type="button" onclick="memberDrop()">회원 탈퇴</button>
		</div>
	</form:form>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />