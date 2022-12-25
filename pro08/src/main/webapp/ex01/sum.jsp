<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="exception.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	int num = Integer.parseInt(request.getParameter("num"));
	int sum = 0;

	for (int i = 1; i <= num; i++)
		sum += i;
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Calculate the sum of integers</title>
</head>
<body>
	<h1>Calculate the sum of integers</h1>

	<p>The sum from 1 to <%= num %> is <%= sum %>.</p>
</body>
</html>
