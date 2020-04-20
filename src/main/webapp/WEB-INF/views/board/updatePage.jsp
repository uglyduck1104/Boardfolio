<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="board-wrap">
	<form action="board-update" method="POST">
		<table>
			<tbody>
				<tr>
					<td>게시글 번호</td>
					<td>#${ bDto.board_no }</td>
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
					<td><input type="text" name="title" value="${bDto.title }" required/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="15" cols="70" name="contents" placeholder="내용을 입력해주세요." required>${bDto.contents }</textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<button type="submit">저장</button>
						<button type="button" onclick="location.href='board-list'">목록으로 이동</button>
						<input type="hidden" name="boardNo" value="${ bDto.board_no }" /> 
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>