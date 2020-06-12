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
window.onload = function(){
	var sortMember = document.getElementById("sort-member");
	var sortWithdraw = document.getElementById("sort-withdraw");
	var sortValue = "${sort}";
	if( sortValue == "user" ){
		sortMember.classList.toggle("active");
	}
	if( sortValue == "withdraw" ){
		sortWithdraw.classList.toggle("active");
	}
};
</script>
<div class="title-wrap">
	<h2>회원 관리</h2>
</div>
<div class="admin-main">
	<div class="sort-wrap">
		<ul>
			<li><a href="javascript:sortList('user')" id="sort-member">회원순</a></li>
			<li><a href="javascript:sortList('withdraw')" id="sort-withdraw">탈퇴 회원순</a></li>
		</ul>
	</div>
	<div class="search-wrap">
		<form action="admin-member-list">
			<div class="search-area">
				<input type="text" id="searchInput" name="query" value="${query}" placeholder="아이디" />
				<button type="button" class="ico"></button>
				<button type="submit" id="searchBtn" /></button>
			</div>
		</form>
	</div>
	<div class="admin-member-wrap">
		<table class="admin-member-area">
			<colgroup>
	       		<col width="*">
	       		<col width="15%">
	       		<col width="20%">
	       		<col width="15%">
	        </colgroup>
			<thead>
				<tr id="head-line">
					<th>아이디</th>
					<th>권한</th>
					<c:if test="${ sort eq 'user' or sort eq 'all'}">
						<th>최초 가입일</th>
					</c:if>
					<c:if test="${ sort eq 'withdraw'}">
						<th>탈퇴일</th>
					</c:if>
					<th>관리</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}" >
					<tr>
						<td colspan="4">등록된 회원이 없습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="mDto" items="${list}">
						<tr>
							<td>${ mDto.id }</td>
							<c:if test="${ mDto.role eq 'user'}">
								<td>회원</td>
							</c:if>
							<c:if test="${ mDto.role eq 'withdraw'}">
								<td>탈퇴 회원</td>
							</c:if>
							<td>${ mDto.reg_date }</td>
							<td><a href="admin-member-view?id=${mDto.id}">상세</a></td>
						</tr>
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
<script type="text/javascript" src="resources/js/admin.js" ></script>
<jsp:include page="/WEB-INF/views/user/myPageR.jsp" />