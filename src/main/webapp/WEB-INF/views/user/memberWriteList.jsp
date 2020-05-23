<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<div class="user-main">
	<div class="title-wrap">
		<h2>내가 쓴 게시물</h2>
	</div>
	<div class="board-wrap">
		<table class="board-list">
			<colgroup>
	       		<col width="20%">
	       		<col width="*">
	       		<col width="25%">
	        </colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}" >
					<tr>
						<td colspan="4">등록된 게시물이 없습니다.</td>
					<tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="bDto" items="${list}">
						<tr>
							<td>${ bDto.board_no }</td>
							<td><a href="board-view?board_no=${bDto.board_no}">${ bDto.title }</a></td>
							<td>${ bDto.board_dt }</td>
						<tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />