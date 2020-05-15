<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<div class="title-wrap">
	<h2>새 글쓰기</h2>
</div>

<div class="board-wrap" >
	<form action="board-write" id="write-form" method="POST">
		<table>
			<tbody>
				<tr>
					<td><input type="text" name="title" id="title" placeholder="제목을 입력해주세요." autofocus required/></td>
				</tr>
				<tr>
					<td class="unreset">
						<textarea name="contents" id="content" placeholder="내용을 입력해주세요."></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td>
						<button type="submit">게시글 등록</button>
						<button type="button" onclick="location.href='board-list'">게시글 목록</button>
						<input type="hidden" name="id" value="${sessionScope.mDto.id }" />
					</td>
				</tr>
			</tfoot>
		</table>	
	</form>
</div>

<script src="resources/js/ckeditor.js"></script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>