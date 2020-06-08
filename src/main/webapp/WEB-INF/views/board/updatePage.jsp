<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="board-view-wrap board-update">
	<div class="title-wrap">
		<h2>DUCKLING</h2>
	</div>
	<form action="board-update" method="POST">
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
					<td>
						<div>
							<span id="boardNo" class="bNum">${bDto.board_no }</span>
							<input type="text" name="title" value="${bDto.title }"/>
							<hr/>
							<textarea name="contents">${bDto.contents }</textarea>
						</div>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<button type="submit">저장</button>
						<button type="button" onclick="location.href='board-list'">취소</button>
						<input type="hidden" name="boardNo" value="${ bDto.board_no }" /> 
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>
<script type="text/javascript" src="resources/js/ckeditor.js" ></script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>