<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<div class="left-menu">
	<div class="title-wrap">
		<h2>MY DUCK</h2>
	</div>
	<dl class="my-menu">
		<dt>나의 정보 관리</dt>
		<dd>
			<ul class="menu-list">
				<li><a href="member-update-page">계정 정보 수정</a></li>
			</ul>
		</dd>
	</dl>
	<dl class="my-menu">
		<dt>나의 활동</dt>
		<dd>
			<ul class="menu-list">
				<li><a href="member-write" onclick="return false;">내가 쓴 게시물</a></li>
				<li><a href="member-reply" onclick="return false;">내가 쓴 댓글</a></li>
			</ul>
		</dd>
	</dl>
</div>
<div class="right-content">
	<div>