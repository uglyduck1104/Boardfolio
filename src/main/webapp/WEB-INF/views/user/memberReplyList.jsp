<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<div class="user-main">
	<div class="title-wrap">
		<h2>내가 쓴 댓글</h2>
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
					<th>게시물 번호</th>
					<th>댓글 내용</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}" >
					<tr>
						<td colspan="3">등록된 댓글이 없습니다.</td>
					<tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="rDto" items="${list}">
						<tr>
							<td><a href="board-view?board_no=${rDto.board_no}">${ rDto.board_no }</a></td>
							<td>${ rDto.reply_con }</td>
							<td>${ rDto.reply_dt }</td>
						<tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />