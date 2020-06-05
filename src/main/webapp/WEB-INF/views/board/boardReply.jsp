<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="POST" id="reply-form">
	<table>
		<tbody>
			<c:if test="${sessionScope.mDto ne null }">
				<tr>
					<td>댓글 작성자</td>
					<td>${ sessionScope.mDto.id }</td>
				</tr>
				<tr>
					<td>댓글 내용</td>
					<td><textarea rows="15" cols="30" name="reply_con" id="reply-con" placeholder="댓글을 입력해주세요."></textarea></td>
				<tr>
					<td>
						<button type="button" id="reply-btn">댓글 등록</button>
					</td>
				</tr>
			</c:if>
			<c:if test="${ sessionScope.mDto eq null }">
				<span>댓글 작성은 <a href="login-form">로그인</a> 후 이용할 수 있습니다.</span>
			</c:if>
			<tr>
				<td>
					<input type="hidden" name="member_id" value="${ sessionScope.mDto.id }" />
					<input type="hidden" id="board_no" name="board_no" value="${ bDto.board_no }" />
				</td>
			</tr>
		</tbody>
	</table>
</form>
<table>
	<tbody id="reply-view"></tbody>
</table>
<script type="text/javascript" src="resources/js/reply.js" ></script>