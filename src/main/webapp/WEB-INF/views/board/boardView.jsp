<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<div class="board-wrap">
	<div class="title-wrap">
		<h2>DUCKLING</h2>
	</div>
	<div class="board-wrap">
		<ul>
			<li>${ bDto.member_id }</li>
			<li>${ bDto.board_dt }</li>
			<li>#${ bDto.board_no }</li>
			<li>${ bDto.title }</li>
			<li>${ bDto.hits_cnt }</li>
			<li>${ bDto.good_cnt }</li>
			<li>${ bDto.reply_cnt }</li>
			<li>${ bDto.contents }</li>
		</ul>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>