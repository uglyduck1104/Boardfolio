<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<script type="text/javascript">
	var isBoardDelete = "${isBoardDelete}";
	if( isBoardDelete == "YES" ){
		var isBoardDeleteRes = "${isBoardDeleteRes}";
		if( isBoardDeleteRes == 0 ){
			alert("게시물 삭제가 실패했습니다.");
		} else {
			alert("게시물이 삭제되었습니다.");
		}
	}
</script>
<div class="user-main">
	<div class="title-wrap">
		<h2>게시글 관리</h2>
	</div>
	<div class="search-wrap">
		<form action="admin-board-list" onsubmit="return dateChk(this);">
			<div class="search-area">
				<div class="search-block">
					<p>작성일</p>
					<input type="text" id="date-search1" name="beginDate" value="${beginDate}" /> ~
					<input type="text" id="date-search2" name="endDate" value="${endDate}"/>
				</div>
				<div class="search-block">
					<p>검색어</p>
					<input type="text" id="searchInput" name="query" value="${query}" placeholder="검색어" />
				</div>
			</div>
			<input type="submit" id="searchBtn" value="검색" />
		</form>
	</div>
	<div>
		<table class="board-list">
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
					<th>작성자</th>
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
							<td><a href="board-view?board_no=${bDto.board_no}&currentPage=${currentPage}">${ bDto.title }</a>
								[${ bDto.reply_cnt }]</td>
							<td>${ bDto.member_id }</td>
							<td>${ bDto.hits_cnt }</td>
							<td>${ bDto.board_dt }</td>
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

		<div class="pageNavi">
			<div class="pagingWrap">
				${ pagingView }
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="resources/js/admin.js"></script>
<!-- bootstrap calendar-->
<script type="text/javascript" src="resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-datepicker.kr.js"></script>
<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />