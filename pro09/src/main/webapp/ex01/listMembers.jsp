<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ex01.*"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member List</title>
</head>
<body>
	<h1>Member List</h1>

	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Account</th>
				<th>Password</th>
				<th>Name</th>
				<th>Email</th>
				<th>Registration Date</th>
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
			<tr>
				<td>${item.id}</td>
				<td>${item.account}</td>
				<td>${item.passwd}</td>
				<td>${item.name}</td>
				<td>${item.email}</td>
				<td>${item.regdate}</td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
		</tbody>
	</table>
</body>
</html>
