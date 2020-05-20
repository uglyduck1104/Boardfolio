<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<div>
	<h1>${ sessionScope.mDto.id }님</h1>
</div>

<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />