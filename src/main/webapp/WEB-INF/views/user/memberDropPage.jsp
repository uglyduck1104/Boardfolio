<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />

<div class="user-main">
	<div class="title-wrap">
		<h2>회원정보 수정</h2>
	</div>
	<form action="member-drop" method="post">
		<div class="cont-wrap">
			<h3>회원 탈퇴시 아래의 조취가 취해 집니다.</h3>
			<ul>
				<li>작성된 게시물은 삭제되지 않으며, 해당 홈페이로 소유권이 귀속됩니다.</li>
				<li>게시물 삭제가 필요한 경우에는 관리자(admin@theuglyduckling.kr)로 문의해 주시기 바랍니다.</li>
			</ul>
				<input type="hidden" value="${ sessionScope.mDto.id }" name="id" />
		</div>
		<div class="cont-btn-wrap">
			<button type="button" onclick="history.back();">아니오</button>
			<button type="submit">예, 탈퇴하겠습니다.</button>
		</div>
	</form>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />