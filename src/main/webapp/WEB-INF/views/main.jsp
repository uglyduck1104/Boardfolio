<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="main-wrap">
	<div class="best-wrap">
		<div class="best-title">
			<h2>Daily Duck</h2>
		</div>
		<div class="best-area">
			<table>
				<colgroup>
		       		<col width="*">
		       		<col width="30%">
		        </colgroup>
				<tbody>
					<c:choose>
						<c:when test="${empty todayBestList}">
							<tr>
								<td colspan="2">오늘의 추천 게시물이 없습니다.</td>
								
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="bDto" items="${todayBestList}">
							<tr class="best-cont">
								<td>
									<span class="bNum">${ bDto.board_no }</span>
									<p>
										<a href="board-view?board_no=${bDto.board_no}">${ bDto.title }</a>
									</p>
								</td>
								<td>
									<span>${ bDto.member_id }</span>
									<p><fmt:formatDate value="${bDto.board_dt }" type="both" /></p>
								</td>
							</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>	
			</table>	
		</div>
	</div>
	<div class="best-wrap">
		<div class="best-title">
			<h2>Weekly Duck</h2>
		</div>
		<div class="best-area">
			<table>
				<colgroup>
		       		<col width="*">
		       		<col width="30%">
		        </colgroup>
				<tbody>
					<c:choose>
						<c:when test="${empty weekBestList}">
							<tr>
								<td colspan="2">주간 추천 게시물이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="bDto" items="${weekBestList}">
							<tr class="best-cont">
								<td>
									<span class="bNum">${ bDto.board_no }</span>
									<p>
										<a href="board-view?board_no=${bDto.board_no}">${ bDto.title }</a>
									</p>
								</td>
								<td>
									<span>${ bDto.member_id }</span>
									<p><fmt:formatDate value="${bDto.board_dt }" type="both" /></p>
								</td>
							</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>	
			</table>	
		</div>
	</div>
	<div class="best-wrap">
		<div class="best-title">
			<h2>Monthly Duck</h2>
		</div>
		<div class="best-area">
			<table>
				<colgroup>
		       		<col width="*">
		       		<col width="30%">
		        </colgroup>
				<tbody>
					<c:choose>
						<c:when test="${empty monthBestList}">
							<tr>
								<td colspan="2">월간 추천 게시물이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="bDto" items="${monthBestList}">
							<tr class="best-cont">
								<td> 
									<span class="bNum">${ bDto.board_no }</span>
									<p>
										<a href="board-view?board_no=${bDto.board_no}">${ bDto.title }</a>
									</p>
								</td>
								<td>
									<span>${ bDto.member_id }</span>
									<p><fmt:formatDate value="${bDto.board_dt }" type="both" /></p>
								</td>
							</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>	
			</table>	
		</div>
	</div>
	<div class="best-wrap">
		<div class="best-title">
			<h2>Yearly Duck</h2>
		</div>
		<div class="best-area">
			<table>
				<colgroup>
		       		<col width="*">
		       		<col width="30%">
		        </colgroup>
				<tbody>
					<c:choose>
						<c:when test="${empty yearBestList}">
							<tr>
								<td colspan="2">연간 추천 게시물이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="bDto" items="${yearBestList}">
							<tr class="best-cont">
								<td>
									<span class="bNum">${ bDto.board_no }</span>
									<p>
										<a href="board-view?board_no=${bDto.board_no}">${ bDto.title }</a>
									</p>
								</td>
								<td>
									<span>${ bDto.member_id }</span>
									<p><fmt:formatDate value="${bDto.board_dt }" type="both" /></p>
								</td>
							</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>	
			</table>	
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %> 