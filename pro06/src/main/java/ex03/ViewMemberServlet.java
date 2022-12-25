package ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewMember")
public class ViewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpServletRequest 객체의 getSession 메서드를 이용해 HttpSession 객체를 생성
		// getSession 메서드의 인자를 false로 지정해서, 세션이 생성되지 않았으면 null을
		// 반환하도록 한다.
		HttpSession session = request.getSession(false);

		// 세션이 생성되어 있는지 확인
		if (session == null) {
			// 세션이 생성되지 않은 경우 login.html로 포워딩
			response.sendRedirect("login.html");
			return;
		}

		// 세션에 바인딩한 정보를 가져옴
		boolean isLoggedin = (Boolean)session.getAttribute("isLoggedin");
		String account = (String)session.getAttribute("account");

		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// 출력 스트림의 PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();

		// 응답할 데이터를 HTML 형식으로 생성
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Member Information</title></head>"
				+ "<body><h1>Member Information</h1>";

		if (isLoggedin && account != null) {
			// 회원 정보를 가져오기 위해 MemberDAO 객체 생성
			MemberDAO memberDAO = new MemberDAO();

			// MemberDAO 객체를 이용해, 데이터베이스의 member 테이블에서 회원 정보를 조회
			MemberVO member = memberDAO.getMember(account);

			output += "<ul><li>Account: " + member.getAccount() + "</li>"
					+ "<li>Name: " + member.getName() + "</li>"
					+ "<li>Email: " + member.getEmail() + "</li>"
					+ "<li>Registration Date: " + member.getRegdate() + "</li></ul>";
		}
		else
			output += "<p>Invalid access!</p>"
					+ "<p><a href=\"login.html\">Please log in again!</a></p>";

		output += "</body></html>";

		// 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림 닫기
		out.close();
	}
}
