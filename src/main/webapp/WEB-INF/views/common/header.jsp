<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Ugly Duckling</title>
<link href="<c:url value="/resources/css/common.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/login.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/join.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/board.css"/>" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/unreset.css"/>" type="text/css" rel="stylesheet">
<script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
var isLogout = "${isLogout}";
if( isLogout == "true" ){
	alert("로그아웃 되었습니다.");
}
</script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div class="header-bg">
				<h1 class="logo-wrap">
					<a href="main"><img alt="logo" src="./resources/images/header-logo.png" /></a>
				</h1>
				<div class="menu-wrap">
					<ul>
						<li><a href="board-list">DUCKLING</a></li>
					</ul>
				</div>
				<div class="info-wrap">
					<c:if test="${ sessionScope.mDto eq null }">
						<ul>
							<li><a href="login-form">Login</a></li>
							<li><a href="sign-form">Sign up</a></li>
						</ul>
					</c:if>
					<c:if test="${ sessionScope.mDto ne null }">
						<ul>
							<li>${ sessionScope.mDto.name }님</li>
							<li><a href="logout">Logout</a></li>
						</ul>
					</c:if>
				</div>
			</div>
		</div>
		<div id="main">