package ex07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMemberList")
public class ViewMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// HttpServletResponse 객체의 getWriter 메서드를 이용해 출력 스트림의 PrintWriter
		// 객체를 받아옴
		PrintWriter out = response.getWriter();

		// HttpServletRequest 객체에 바인딩된 회원 목록을 가져온다.
		// getAttribute 메서드가 반환하는 값은 Object 자료형이다. 따라서 List 클래스의
		// 참조 변수에 대입하려면 반드시 형 변환을 해야 한다.
		List<?> memberList = (List<?>)request.getAttribute("memberList");

		// 클라이언트에 출력할 데이터
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\"><title>Member List</title>"
				+ "</head><body><h1>Member List</h1><table border=\"1\"><thead><tr>"
				+ "<th>ID</th><th>Account</th><th>Password</th><th>Name</th>"
				+ "<th>Email</th><th>Registration Date</th><th>Delete</th></tr></thead><tbody>";

		// ArrayList 객체에 저장된 MemberVO 객체에서 데이터를 가져와서 표를 생성
		for (Object obj : memberList) {
			// MemberVO 클래스의 메서드를 이용하기 위해, Object 객체인 obj를
			// MemberVO 클래스로 형 변환한다.
			MemberVO member = (MemberVO)obj;

			output += "<tr><td>" + member.getId() + "</td>"
					+ "<td>" + member.getAccount() + "</td>"
					+ "<td>" + member.getPasswd() + "</td>"
					+ "<td>" + member.getName() + "</td>"
					+ "<td>" + member.getEmail() + "</td>"
					+ "<td>" + member.getRegdate() + "</td>"
					+ "<td><a href=\"/pro04/member4?command=delete&id=" + member.getId()
					+ "\">[X]</a></td></tr>";
		}

		output += "</tbody></table>"
				+ "<p><a href=\"/pro04/memberForm.html\">Membership Registration Form</a></p>"
				+ "</body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
