<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ex02.*"
	import="java.util.List"
	pageEncoding="UTF-8" %>
<%
// 클라이언트에서 전달한 데이터의 인코딩 설정
request.setCharacterEncoding("utf-8");

// 클라이언트에서 전달한 값을 구해옴
String name = request.getParameter("name");

// MemberDAO 객체 생성
MemberDAO memberDAO = new MemberDAO();

// 클라이언트에서 전달된 name 속성으로 회원 목록을 생성
List<MemberVO> memberList = memberDAO.getMemberListByName(name);
%>
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
<% for (MemberVO member : memberList) { %>
			<tr>
				<td><% out.print(member.getId()); %></td>
				<td><%= member.getAccount() %></td>
				<td><%= member.getPasswd() %></td>
				<td><%= member.getName() %></td>
				<td><%= member.getEmail() %></td>
				<td><%= member.getRegdate() %></td>
			</tr>
<% } %>
		</tbody>
	</table>

	<p>[<a href="index.html">Lookup a Member</a>]</p>
</body>
</html>
