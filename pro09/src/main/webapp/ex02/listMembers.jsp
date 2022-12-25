<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ex02.*"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member List</title>
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<script>
		$(function () {
			$(".delete").on("click", function () {
				if (!window.confirm("Are you sure to delete the member?"))
					return false;

				if (!window.confirm("Once deleted, it cannot be recovered. "
						+ "Are you sure to delete the member?"))
					return false;
			});
		});
	</script>
</head>
<body>
	<h1>Member List</h1>

<c:choose>
	<c:when test="${message == 'registerMember'}">
	<h2>Registered a new member!</h2>
	</c:when>
	<c:when test="${message == 'updateMember'}">
	<h2>Updated the member!</h2>
	</c:when>
	<c:when test="${message == 'deleteMember'}">
	<h2>Deleted the member!</h2>
	</c:when>
</c:choose>

	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Account</th>
				<th>Password</th>
				<th>Name</th>
				<th>Email</th>
				<th>Registration Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
<c:choose>
	<c:when test="${empty memberList}">
			<tr>
				<td colspan="6">There are no registered members.</td>
			</tr>
	</c:when>
	<c:otherwise>
		<c:forEach var="item" items="${memberList}">
			<c:set var="updateURI" value="/member/updateForm.do?account=${item.account}" />
			<c:set var="deleteURI" value="/member/deleteMember.do?id=${item.id}" />
			<tr>
				<td>${item.id}</td>
				<td>${item.account}</td>
				<td>${item.passwd}</td>
				<td>${item.name}</td>
				<td>${item.email}</td>
				<td>${item.regdate}</td>
				<td>
					[<a href="${contextPath}${updateURI}">UPDATE</a>]
					[<a href="${contextPath}${deleteURI}" class="delete">DELETE</a>]
				</td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
		</tbody>
	</table>
</body>
</html>
