<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<div class="my-page-cont">
	<c:if test="${sessionScope.mDto.role eq 'user' }">
		<div class="main-top">
			<h1>${ sessionScope.mDto.id }님</h1>
		</div>
		<div class="main-bottom">
			<ul>
				<li>
					<a href="member-write-list">내가 쓴 게시글</a>
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
					<a href="member-reco-list">내가 추천한 게시글</a>
					<p>${recommendCount }개</p>
				</li>
			</ul>
		</div>
	</c:if>
	<c:if test="${sessionScope.mDto.role eq 'admin' }">
		<div class="main-top">
			<h1>관리자님</h1>
		</div>
		<div class="main-bottom">
			<div>
				<a class="caption-title" href="admin-member-list">회원 관리</a>
				<ul>
					<li>
						<span>회원</span>
						<p>${memberCount }명</p>
					</li>
				</ul>
				<ul>
					<li class="mid-col">
						<span>탈퇴 회원</span>
						<p>${withdrawCount }명</p>
					</li>
				</ul>
			</div>
			<div>
				<a class="caption-title" href="admin-board-list">게시글 관리</a>
				<ul>
					<li>
						<span>총 게시글</span>
						<p>${boardCount }개</p>
					</li>
				</ul>
				<ul>
					<li class="mid-col">
						<span>총 댓글</span>
						<p>${replyCount }개</p>
					</li>
				</ul>
				<ul>
					<li class="mid-col">
						<span>총 추천글</span>
						<p>${recommendCount }개</p>
					</li>
				</ul>
			</div>
		</div>
	</c:if>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />