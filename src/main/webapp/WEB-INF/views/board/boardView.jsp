<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<script>
var board_no = "${bDto.board_no}";
function updatePage(){
	location.href="update-page?board_no=" + board_no;
}
function deleteBoard(){
	if(confirm("게시글을 삭제하시겠습니까?")){
		location.href="board-drop?board_no=" + board_no;
	}
}
</script>
<div class="board-view-wrap">
	<table>
		<tbody>
			<tr>
				<td>
					<div class="info-wrap">
						<span>${ bDto.member_id }</span>
						<p class="date-format"><fmt:formatDate value="${bDto.board_dt }" type="both" /></p>
					</div>
					<div class="cnt-wrap">
						<c:choose>
							<c:when test="${ bDto.reply_cnt gt 999}">
								<p class="txt-format reply-cnt"><fmt:parseNumber value="${ bDto.reply_cnt/1000 }" integerOnly="true" />k</p>
							</c:when>
							<c:otherwise>
								<p class="txt-format reply-cnt">${ bDto.reply_cnt }</p>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${ bDto.good_cnt gt 999}">
								<p class="txt-format good-cnt"><fmt:parseNumber value="${ bDto.good_cnt/1000 }" integerOnly="true" />k</p>
							</c:when>
							<c:otherwise>
								<p class="txt-format good-cnt">${ bDto.good_cnt }</p>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${ bDto.hits_cnt gt 999}">
								<p class="txt-format hits-cnt"><fmt:parseNumber value="${ bDto.hits_cnt/1000 }" integerOnly="true" />k</p>
							</c:when>
							<c:otherwise>
								<p class="txt-format hits-cnt">${ bDto.hits_cnt }</p>
							</c:otherwise>
						</c:choose>
					</div>
				</td>
			</tr>
			<tr>
				<c:if test="${ sessionScope.mDto ne null }">
					<td>
						<div>
							<span id="boardNo" class="bNum">${bDto.board_no }</span>
							<h2>${bDto.title }</h2>
							<div class="title-navi">
								<c:if test="${ sessionScope.mDto.id eq bDto.member_id }">
									<button type="button" onclick="updatePage()">수정</button>
									<button type="button" onclick="deleteBoard()">삭제</button>
								</c:if>
									<button type="button" onclick="location.href='board-list'">목록으로 이동</button>
							</div>
							<hr/>
							<div class="unreset">${bDto.contents }</div>
						</div>
						<div class="recommend-btn-wrap">
							<button type="button" id="goodStat" onclick="countRecs('good')"><span>추천하기</span></button>
							<button type="button" id="badStat" onclick="countRecs('bad')"><span>비추천하기</span></button>
							<input type="hidden" id="memberId" value="${ sessionScope.mDto.id }" />
						</div>
					</td>
					</c:if>
					<c:if test="${ sessionScope.mDto eq null }">
					<td class="resizeWrap">
						<div class="resizeArea">
							<span id="boardNo" class="bNum">${bDto.board_no }</span>
							<h2>${bDto.title }</h2>
							<div class="title-navi">
								<button type="button" onclick="location.href='board-list'">목록으로 이동</button>
							</div>
							<hr/>
							<div class="unreset">${bDto.contents }</div>
						</div>
					</td>
				</c:if>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="/WEB-INF/views/board/boardReply.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>