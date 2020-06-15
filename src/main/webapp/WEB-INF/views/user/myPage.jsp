<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<div class="my-page-cont">
	<div class="main-top">
		<h1>${ sessionScope.mDto.id }님</h1>
	</div>
	<div class="main-bottom">
		<ul>
			<li>
				<a href="member-write-list">내가 쓴 게시물</a>
				<p>${boardCount }개</p>
			</li>
		</ul>
		<ul>
			<li class="mid-col">
				<a href="member-reply-list">내가 쓴 댓글</a>
				<p>${replyCount }개</p>
			</li>
		</ul>
		<ul>
			<li class="mid-col">
				<a href="member-reco-list">내가 추천한 게시물</a>
				<p>${recommendCount }개</p>
			</li>
		</ul>
	</div>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />