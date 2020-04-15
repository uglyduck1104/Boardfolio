<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<div class="title-wrap">
	<h2>DUCKLING</h2>
</div>
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
				<th>추천수</th>
				<th>날짜</th>
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
						</tr>
						<tr>
							<td>${ bDto.title }</td>
						</tr>
						<tr>
							<td>${ bDto.member_id }</td>
						</tr>
						<tr>
							<td>${ bDto.hits_cnt }</td>
						</tr>
						<tr>
							<td>${ bDto.board_dt }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>