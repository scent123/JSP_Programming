<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true" %>
<%-- exception 내장 객체를 이용해, 콘솔에 예외 메시지를 출력 --%>
<% exception.printStackTrace(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Exception Handling</title>
</head>
<body>
	<h1>Oops! Something is wrong!</h1>

	<h2>exception.toString</h2>
	<pre><%= exception.toString() %></pre>

	<h2>exception.getMessage</h2>
	<pre><%= exception.getMessage() %></pre>
</body>
</html>
