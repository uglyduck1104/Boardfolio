<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="/WEB-INF/views/common/header.jsp" />
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
	var isBoardUpdate = "${isBoardUpdate}";
	if(isBoardUpdate == "YES"){
		var isBoardUpdateRes = "${isBoardUpdateRes}";
		if( isBoardUpdateRes == 0 ){
			alert("게시물 수정이 실패했습니다.");
		} else {
			alert("게시물 수정이 성공했습니다.");
		}		
	} 
	var isBoardWrite = "${isBoardWrite}";
	if(isBoardWrite == "YES"){
		var isBoardWriteRes = "${isBoardWriteRes}";
		if( isBoardWriteRes == 0 ){
			alert("게시물 작성이 실패했습니다.");
		} else {
			alert("게시물 작성이 성공했습니다.");
		}		
	} 
	function sortList(sortValue){
		var searchInput = document.getElementById("searchInput").value;
		location.href = "board-list?sort=" + sortValue + "&query=" + searchInput;
	}

</script>
<div class="board-wrap">
	<div class="title-wrap">
		<h2>DUCKLING</h2>
	</div>
	<div>
		<div class="sort-wrap">
			<ul>
				<li><a href="javascript:sortList('latest')">최신순</a></li>
				<li><a href="javascript:sortList('recommend')">추천순</a></li>
				<li><a href="javascript:sortList('reply')">댓글순</a></li>
				<li><a href="javascript:sortList('hit')">조회순</a></li>
			</ul>
		</div>
		<div class="button-wrap">
			<a href="write-page">새 글쓰기</a>
		</div>
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
					<tr>
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
						<tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div class="search-wrap">
			<form action="board-list">
				<div class="searchArea">
					<input type="text" id="searchInput" name="query" value="${query}"placeholder="검색어" />
					<input type="submit" id="searchBtn" value="검색" />
				</div>
			</form>
		</div>
		<div class="pageNavi">
			<div class="pagingWrap">
				${ pagingView }
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>