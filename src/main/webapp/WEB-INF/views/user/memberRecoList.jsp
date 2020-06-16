<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<div class="user-main">
	<div class="cont-title">
		<h2>내가 추천한 게시글</h2>
	</div>
	<div class="board-wrap">
		<table class="board-list">
			<colgroup>
	       		<col width="50%">
	       		<col width="15%">
	        </colgroup>
			<tbody id="board-reco-list">
			</tbody>
		</table>
		<input type="hidden" id="id" value=${ sessionScope.mDto.id } />
	</div>
</div>
<script type="text/javascript" src="resources/js/myRecoList.js" ></script>
<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />