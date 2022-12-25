<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- 현재 요청이 등록(register)인지 갱신(update)인지 확인 --%>
<%-- 이러한 확인은 컨트롤러(controller)에서 확인하고 바인딩하는 게 편하다! --%>
<c:choose>
	<c:when test="${not empty member and not empty member.account}">
		<c:set var="action" value="update" />
	</c:when>
	<c:otherwise>
		<c:set var="action" value="register" />
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Membership Registration Form</title>
	<style>
		#reg > p > label {
			display: inline-block;
			width: 90px;
			padding-right: 1em;
			text-align: right;
		}
	</style>
	<script>
		window.addEventListener("load", function () {
			document.getElementById("reg").addEventListener("submit", function (event) {
				var lenAccount = this.account.value.length;
				var lenPasswd = this.passwd.value.length;
				var lenName = this.name.value.length;
				var lenEmail = this.email.value.length;

				if (!lenAccount || !lenPasswd || !lenName || !lenEmail) {
					window.alert("You must fill out all input forms!");
					event.preventDefault();
					return;
				}
			});
		});
	</script>
</head>
<body>
	<h1>Membership Registration Form</h1>

	<form action="${contextPath}/member/${action}Member.do" method="post" id="reg">
<c:choose>
	<c:when test="${action == 'update'}">
		<input type="hidden" name="id" value="${member.id}">
		<input type="hidden" name="account" value="${member.account}">
		<p><label>Account: </label>${member.account}</p>
	</c:when>
	<c:otherwise>
		<p><label>Account: </label><input type="text" name="account"></p>
	</c:otherwise>
</c:choose>
		<p><label>Password: </label><input type="password" name="passwd"
			value="${member.passwd}"></p>
		<p><label>Name: </label><input type="text" name="name" value="${member.name}"></p>
		<p><label>Email: </label><input type="text" name="email" value="${member.email}"></p>
		<p><input type="submit" name="submit" value="Register"></p>
	</form>
</body>
</html>
