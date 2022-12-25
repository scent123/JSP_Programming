<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ex02.*"
	import="java.util.List"
	pageEncoding="UTF-8" %>
<%
// 클라이언트에서 전달한 데이터의 인코딩 설정
request.setCharacterEncoding("utf-8");

/*
// 클라이언트에서 전송한 값을 저장할 MemberVO 객체를 생성
MemberVO member = new MemberVO();
*/
%>

<%-- useBean 액션 태그를 이용해 자바빈 생성 --%>
<jsp:useBean id="member" class="ex02.MemberVO" />

<%
/*
// 설정자(setter)를 이용해 member 객체에 추가할 회원 정보를 설정
member.setAccount(request.getParameter("account"));
member.setPasswd(request.getParameter("passwd"));
member.setName(request.getParameter("name"));
member.setEmail(request.getParameter("email"));
*/
%>

<%-- setProperty 액션 태그를 이용해 자바빈의 속성을 설정 --%>
<%-- request 객체의 getParameter 메서드를 이용해, 클라이언트에서 전달한 값을 value 속성에 설정 --%>
<%--
<jsp:setProperty name="member" property="account"
		value="<%= request.getParameter("account") %>" />
<jsp:setProperty name="member" property="passwd"
		value="<%= request.getParameter("passwd") %>" />
<jsp:setProperty name="member" property="name"
		value="<%= request.getParameter("name") %>" />
<jsp:setProperty name="member" property="email"
		value="<%= request.getParameter("email") %>" />
--%>

<%-- setProperty 액션 태그를 이용해 자바빈의 속성을 설정 --%>
<%-- setProperty 액션 태그의 value 속성의 값이 클라이언트에서 전달한 값이라면
     param 속성에 요청 매개변수만 명시해도 된다. --%>
<%--
<jsp:setProperty name="member" property="account" param="account" />
<jsp:setProperty name="member" property="passwd" param="passwd" />
<jsp:setProperty name="member" property="name" param="name" />
<jsp:setProperty name="member" property="email" param="email" />
--%>

<%-- setProperty 액션 태그를 이용해 자바빈의 속성을 설정 --%>
<%-- setProperty 액션 태그의 property 속성의 값과 param 속성의 값이 같으면
     param 속성을 생략할 수 있다. --%>
<%--
<jsp:setProperty name="member" property="account" />
<jsp:setProperty name="member" property="passwd" />
<jsp:setProperty name="member" property="name" />
<jsp:setProperty name="member" property="email" />
--%>

<%-- setProperty 액션 태그를 이용해 자바빈의 속성을 설정 --%>
<%-- 자바빈의 속성의 이름과 요청 매개변수의 이름이 같으면, setProperty 액션 태그의
     property 속성에 "*(와일드카드 문자)"를 쓸 수 있다. --%>
<jsp:setProperty name="member" property="*" />

<%
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
