<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="board-wrap">
	<table>
		<tbody>
			<tr>
				<td>아이디</td>
				<td>${mDto.id }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${mDto.name }</td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td>${mDto.nickname }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${mDto.email }</td>
			</tr>
			<tr>
				<td>아이피</td>
				<td>${mDto.ip }</td>
			</tr>
			<tr>
				<td>가입일</td>
				<td><fmt:formatDate value="${mDto.reg_date }" type="both" /></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>${mDto.role }</td>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>