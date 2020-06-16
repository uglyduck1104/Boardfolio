<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="my-page-wrap">
	<div class="left-menu">
		<div class="title-wrap">
			<h2>MY DUCK</h2>
		</div>
		<c:if test="${ sessionScope.mDto.role eq 'user' }">
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
					<li><a href="member-write-list">내가 쓴 게시글</a></li>
					<li><a href="member-reply-list">내가 쓴 댓글</a></li>
					<li><a href="member-reco-list">내가 추천한 게시글</a></li>
				</ul>
			</dd>
		</dl>
		</c:if>
		<c:if test="${ sessionScope.mDto.role eq 'admin' }">
			<dl class="my-menu">
				<dt>회원 정보 관리</dt>
				<dd>
					<ul class="menu-list">
						<li><a href="admin-member-list">회원 관리</a></li>
					</ul>
				</dd>
			</dl>
			<dl class="my-menu">
				<dt>게시글 관리</dt>
				<dd>
					<ul class="menu-list">
						<li><a href="admin-board-list">게시글 관리</a></li>
					</ul>
				</dd>
			</dl>
		</c:if>
	</div>
	<div class="right-content">
		<div>