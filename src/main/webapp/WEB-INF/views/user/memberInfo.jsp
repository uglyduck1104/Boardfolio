<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<script>
function pwUpdatePage(){
	location.href="pw-update-page";
}
function memberDrop(){
	location.href="member-drop-page";
}
</script>
<div class="user-main">
	<div class="cont-title">
		<h2>회원정보 수정</h2>
	</div>
	<form:form action="member-update" method="post" modelAttribute="memberDto">
		<div class="cont-wrap">
			<h3>회원님의 소중한 정보를 안전하게 관리하세요.</h3>
			<div class="cont-info">
				<ul>
					<li>
						<label for="member-name">이름</label>
						<form:input path="name" id="member-name" value="${ mDto.name }" placeholder="이름" />
						<form:errors path="name" cssClass="error-msg" element="li"/>
					</li>
					<li>
						<label for="member-nickname">닉네임</label>
						<form:input path="nickname" id="member-nickname" value="${ mDto.nickname }" placeholder="닉네임" />
						<form:errors path="nickname" cssClass="error-msg" element="li"/>
					</li>
					<li>
						<label for="member-email">이메일</label>
						<form:input path="email" id="member-email" value="${ mDto.email }" placeholder="이메일" />
						<form:errors path="email" cssClass="error-msg" element="li"/>
					</li>
					<li>
						<input type="hidden" name="id" value="${sessionScope.mDto.id }" />
						<button type="submit">정보 수정</button>
					</li>
				</ul>
				<div>
					<button type="button" onclick="pwUpdatePage()">비밀번호 변경</button>
					<button type="button" onclick="memberDrop()">회원 탈퇴</button>
				</div>
			</div>
		</div>
	</form:form>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />