<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<div class="board-wrap">
	<div class="title-wrap">
		<h2>DUCKLING</h2>
	</div>
	<c:if test="${ sessionScope.mDto.id ne null }">
		<div class="button-wrap">
			<a href="write-page">새 글쓰기</a>
		</div>
	</c:if>
	<div class="board-wrap">
		<table>
			<colgroup>
	       		<col width="10%">
	       		<col width="*">
	       		<col width="15%">
	       		<col width="15%">
	       		<col width="15%">
	        </colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}" >
						<tr>
							<td colspan="5">등록된 게시물이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="bDto" items="${list}">
							<tr>
								<td>${ bDto.board_no }</td>
								<td><a href="board-view?board_no=${bDto.board_no}">${ bDto.title }</a>
									[${ bDto.reply_cnt }]</td>
								<td>${ bDto.member_id }</td>
								<td>${ bDto.hits_cnt }</td>
								<td>${ bDto.board_dt }</td>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>