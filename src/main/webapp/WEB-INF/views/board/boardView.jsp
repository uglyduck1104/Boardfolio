<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
<div class="board-wrap">
	<table>
		<tbody>
			<tr>
				<td>게시글 번호</td>
				<td id="boardNo">${bDto.board_no }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${bDto.member_id }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${bDto.hits_cnt }</td>
			</tr>
			<tr>
				<td>추천수</td>
				<td>${bDto.good_cnt }</td>
			</tr>
			<tr>
				<td>댓글수</td>
				<td>${bDto.reply_cnt }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${bDto.board_dt }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${bDto.title }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><pre class="unreset">${bDto.contents }</pre></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">
				<c:if test="${ sessionScope.mDto.id eq bDto.member_id }">
					<button type="button" onclick="updatePage()">수정</button>
					<button type="button" onclick="deleteBoard()">삭제</button>
				</c:if>
					<button type="button" onclick="location.href='board-list'">목록으로 이동</button>
				</td>
			</tr>
		</tfoot>
	</table>
	<c:if test="${ sessionScope.mDto ne null }">
		<div>
			<button type="button" id="goodStat" onclick="countRecs('good')">추천하기</button>
			<button type="button" id="badStat" onclick="countRecs('bad')">비추천하기</button>
			<input type="hidden" id="memberId" value="${ sessionScope.mDto.id }" />
		</div>
	</c:if>
</div>
<%@ include file="/WEB-INF/views/common/boardReply.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>