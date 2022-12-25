<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ex02.*"
	import="java.util.List"
	pageEncoding="UTF-8" %>
<%
// 클라이언트에서 전달한 데이터의 인코딩 설정
request.setCharacterEncoding("utf-8");

// 클라이언트에서 전송한 값을 저장할 MemberVO 객체를 생성
MemberVO member = new MemberVO();

// 설정자(setter)를 이용해 member 객체에 추가할 회원 정보를 설정
member.setAccount(request.getParameter("account"));
member.setPasswd(request.getParameter("passwd"));
member.setName(request.getParameter("name"));
member.setEmail(request.getParameter("email"));

// MemberDAO 객체 생성
MemberDAO memberDAO = new MemberDAO();

// 새로운 회원 정보 등록
if (member.getAccount() != null)
	memberDAO.insertMember(member);

// 전체 회원 목록 구해오기
List<MemberVO> memberList = memberDAO.getMemberList();
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
<% if (memberList.size() == 0) { %>
			<tr>
				<td colspan="6">There are no registered members.</td>
			</tr>
<% } else { %>
<% for (MemberVO item : memberList) { %>
			<tr>
				<td><% out.print(item.getId()); %></td>
				<td><%= item.getAccount() %></td>
				<td><%= item.getPasswd() %></td>
				<td><%= item.getName() %></td>
				<td><%= item.getEmail() %></td>
				<td><%= item.getRegdate() %></td>
			</tr>
<% } %>
<% } %>
		</tbody>
	</table>

	<p>[<a href="memberForm.html">Register New Member</a>]</p>
</body>
</html>
