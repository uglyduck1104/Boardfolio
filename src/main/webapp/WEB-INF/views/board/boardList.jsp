<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
window.onload = function(){
	var sortLatest = document.getElementById("sort-latest");
	var sortRecommend = document.getElementById("sort-recommend");
	var sortReply = document.getElementById("sort-reply");
	var sortHit = document.getElementById("sort-hit");
	var sortValue = "${sort}";
	if( sortValue == "latest" ){
		sortLatest.classList.toggle("active");
	}
	if( sortValue == "recommend" ){
		sortRecommend.classList.toggle("active");
	}
	if( sortValue == "reply" ){
		sortReply.classList.toggle("active");
	}
	if( sortValue == "hit" ){
		sortHit.classList.toggle("active");
	}
	
};
</script>
<div class="board-wrap">
	<div class="title-wrap">
		<h2>DUCKLING</h2>
	</div>
	<div class="head-list">
		<div class="sort-wrap">
			<ul>
				<li><a href="javascript:sortList('latest', this)" id="sort-latest">최신순</a></li>
				<li><a href="javascript:sortList('recommend', this)" id="sort-recommend">추천순</a></li>
				<li><a href="javascript:sortList('reply', this)" id="sort-reply">댓글순</a></li>
				<li><a href="javascript:sortList('hit', this)" id="sort-hit">조회순</a></li>
			</ul>
		</div>
		<div class="button-wrap">
			<a href="write-page">새 글쓰기</a>
		</div>
		<div class="search-wrap">
			<form action="board-list">
				<div class="searchArea">
					<input type="text" id="searchInput" name="query" value="${query}"placeholder="검색어" />
					<button type="button" class="ico"></button>
					<button type="submit" id="searchBtn" /></button>
				</div>
			</form>
		</div>
	</div>
	<div>
		<table class="board-list">
			<colgroup>
	       		<col width="45%">
	       		<col width="5%">
	       		<col width="5%"> 
	       		<col width="5%">
	       		<col width="13%">
	        </colgroup>
			<tbody> 
				<c:choose>
					<c:when test="${empty list}">
					<tr>
						<td colspan="5">등록된 게시물이 없습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="bDto" items="${list}">
						<tr>
							<td>
								<span class="bNum">${ bDto.board_no }</span>
								<p>
									<a href="board-view?board_no=${bDto.board_no}&currentPage=${currentPage}">${ bDto.title }</a>
								</p>
							</td>
							<c:choose>
								<c:when test="${ bDto.reply_cnt gt 999}">
									<td class="txt-format reply-cnt"><fmt:parseNumber value="${ bDto.reply_cnt/1000 }" integerOnly="true" />k</td>
								</c:when>
								<c:otherwise>
									<td class="txt-format reply-cnt">${ bDto.reply_cnt }</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ bDto.good_cnt gt 999}">
									<td class="txt-format good-cnt"><fmt:parseNumber value="${ bDto.good_cnt/1000 }" integerOnly="true" />k</td>
								</c:when>
								<c:otherwise>
									<td class="txt-format good-cnt">${ bDto.good_cnt }</td>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${ bDto.hits_cnt gt 999}">
									<td class="txt-format hits-cnt"><fmt:parseNumber value="${ bDto.hits_cnt/1000 }" integerOnly="true" />k</td>
								</c:when>
								<c:otherwise>
									<td class="txt-format hits-cnt">${ bDto.hits_cnt }</td>
								</c:otherwise>
							</c:choose>
							<td>
								<span>${ bDto.member_id }</span>
								<p class="date-format"><fmt:formatDate value="${bDto.board_dt }" type="both" /></p>
							</td>
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
<script type="text/javascript" src="resources/js/board.js" ></script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>