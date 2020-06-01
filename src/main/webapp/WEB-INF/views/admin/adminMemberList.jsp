<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/user/myPageL.jsp" />
<script>
var isAdminMemberDrop = "${isAdminMemberDrop}";
if( isAdminMemberDrop == "YES" ){
	var isAdminMemberDropRes = "${isAdminMemberDropRes}";
	if( isAdminMemberDropRes > 0 ){
		alert("회원 탈퇴가 정상적으로 처리되었습니다.");
	} else {
		alert("회원 탈퇴 처리가 실패했습니다.");
	}
}
function sortList(sortValue){
	var searchInput = document.getElementById("searchInput").value;
	location.href = "admin-member-list?sort=" + sortValue + "&query=" + searchInput;
}
</script>
<div class="user-main">
	<div class="title-wrap">
		<h2>회원 관리</h2>
	</div>
	<div class="sort-wrap">
		<ul>
			<li><a href="javascript:sortList('user')">회원순</a></li>
			<li><a href="javascript:sortList('withdraw')">탈퇴 회원순</a></li>
		</ul>
	</div>
	<div class="search-wrap">
		<form action="admin-member-list">
			<div class="searchArea">
				<input type="text" id="searchInput" name="query" value="${query}" placeholder="아이디" />
				<input type="submit" value="검색" />
			</div>
		</form>
	</div>
	<div class="board-wrap">
		<table class="board-list">
			<colgroup>
	       		<col width="35%">
	       		<col width="*">
	       		<col width="40%">
	        </colgroup>
			<thead>
				<tr>
					<th>아이디</th>
					<th>권한</th>
					<c:if test="${ sort eq 'user' or sort eq 'all'}">
						<th>최초 가입일</th>
					</c:if>
					<c:if test="${ sort eq 'withdraw'}">
						<th>탈퇴일</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}" >
					<tr>
						<td colspan="3">등록된 회원이 없습니다.</td>
					<tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="mDto" items="${list}">
						<tr>
							<td><a href="admin-member-view?id=${mDto.id}">${ mDto.id }</a></td>
							<c:if test="${ mDto.role eq 'user'}">
								<td>회원</td>
							</c:if>
							<c:if test="${ mDto.role eq 'withdraw'}">
								<td>탈퇴 회원</td>
							</c:if>
							<td>${ mDto.reg_date }</td>
						<tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div class="pageNavi">
			<div class="pagingWrap">
				${ pagingView }
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />