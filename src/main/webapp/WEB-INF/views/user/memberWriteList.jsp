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
			<tbody id="board-write-list">
			</tbody>
		</table>
		<input type="hidden" id="id" value=${ sessionScope.mDto.id } />
	</div>
</div>
<script type="text/javascript" src="resources/js/myBoardList.js" ></script>
<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />