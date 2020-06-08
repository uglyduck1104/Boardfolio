<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="board-reply">
	<table>
		<tbody id="reply-view"></tbody>
	</table>
	<form method="POST" id="reply-form">
		<table>
			<tbody>
				<c:if test="${sessionScope.mDto ne null }">
					<tr>
						<td>
							<div>
								<span>${ sessionScope.mDto.id }</span>
								<textarea name="reply_con" id="reply-con" placeholder="댓글 쓰기"></textarea>
							</div>
							<div>
								<button type="button" id="reply-btn">등록</button>
							</div>
						</td>
					</tr>
				</c:if>
				<c:if test="${ sessionScope.mDto eq null }">
					<tr><td><span>댓글 작성은 <a href="login-form" class="highlight">로그인</a> 후 이용할 수 있습니다.</span></td></tr>
				</c:if>
			</tbody>
		</table>
		<input type="hidden" name="member_id" value="${ sessionScope.mDto.id }" />
		<input type="hidden" id="board_no" name="board_no" value="${ bDto.board_no }" />
	</form>
</div>
<script type="text/javascript" src="resources/js/reply.js" ></script>