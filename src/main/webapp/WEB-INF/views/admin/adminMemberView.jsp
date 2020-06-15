<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<script>
	function memberDrop(){
		if( confirm('해당 회원을 탈퇴 처리하겠습니까?') ){
			return true;
		}
		return false;
	}
</script>
<div class="admin-view-wrap">
	<c:if test="${ mDto.role eq 'user' }">
		<form action="admin-member-drop" method="post" onsubmit="return memberDrop();">
			<input type="hidden" name="id" value="${ mDto.id }" /> 
			<button type="submit">강제 탈퇴</button>
		</form>
	</c:if>
	<div class="member-title">
		<h2>기본정보</h2>
	</div>
	<table>
		<tbody>
			<tr>
				<td>가입일</td>
				<td><fmt:formatDate value="${mDto.reg_date }" type="both" /></td>
			</tr>
		</tbody>
	</table>
	<div class="member-title">
		<h2>개인정보</h2>
	</div>
	<table>
		<tbody>
			<tr>
				<td>아이디</td>
				<td>${mDto.id }</td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td>${mDto.nickname }</td>
			</tr>
			<c:if test="${mDto.role eq 'user'}">
				<tr>
					<td>이메일</td>
					<td>${mDto.email }</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${mDto.name }</td>
				</tr>
				<tr>
					<td>권한</td>
				<c:if test="${ mDto.role eq 'user'}">
					<td>회원</td>
				</c:if>
				<c:if test="${ mDto.role eq 'withdraw'}">
					<td>탈퇴 회원</td>
				</c:if>
				</tr>
			</c:if>
		</tbody>
	</table>
	<div class="member-title">
		<h2>활동정보</h2>
	</div>
	<table>
		<tbody>
			<c:if test="${ mDto.role eq 'user'}">
				<tr>
					<td>최근 접속 아이피</td>
					<td>${mDto.ip }</td>
				</tr>
			</c:if>
			<c:choose>
				<c:when test="${ mDto.role eq 'user' }">
					<tr>
						<td>최근 접속일</td>
					<c:if test="${ mDto.log ne null }">
						<td><fmt:formatDate value="${mDto.log }" type="both"/></td>
					</c:if>
					<c:if test="${ mDto.log eq null }">
						<td>접속 기록이 없습니다.</td>
					</c:if>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>탈퇴일</td>
					<c:if test="${ mDto.log ne null }">
						<td><fmt:formatDate value="${mDto.log }" type="both"/></td>
					</c:if>
					</tr>
				</c:otherwise>	
			</c:choose>
			<tr>
				<td>등록한 게시물 개수</td>
				<c:if test="${ boardCount gt 0 }">
					<td>${boardCount }개</td>
				</c:if>
				<c:if test="${ boardCount le 0 }">
					<td>0개</td>
				</c:if>
			</tr>
			<tr>
				<td>등록한 댓글 수</td>
				<c:if test="${ replyCount gt 0 }">
					<td>${replyCount }개</td>
				</c:if>
				<c:if test="${ replyCount le 0 }">
					<td>0개</td>
				</c:if>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>