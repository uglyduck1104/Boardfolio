<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<div class="user-main">
	<div class="title-wrap">
		<h2>회원 관리</h2>
	</div>
	<div class="board-wrap">
		<table class="board-list">
			<thead>
				<tr>
					<th>아이디</th>
					<th>권한</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}" >
					<tr>
						<td colspan="3">등록된 회원이 없습니다.</td>
					<tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="mDto" items="${list}">
						<tr>
							<td><a href="admin-member-view?id=${mDto.id}">${ mDto.id }</a></td>
							<td>${ mDto.role }</td>
							<td>${ mDto.reg_date }</td>
						<tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />