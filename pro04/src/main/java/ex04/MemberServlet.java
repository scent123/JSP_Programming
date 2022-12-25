package ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member4")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 전송한 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// 클라이언트에서 전송한 값을 구해옴
		String command = request.getParameter("command");
		String id = request.getParameter("id");

		// 회원 정보 삭제
		if (command != null && command.equals("delete") && id != null) {
			// 회원 정보를 삭제하기 위해 MemberDAO 객체 생성
			MemberDAO memberDAO = new MemberDAO();

			// 주어진 id 정보로 회원 정보를 삭제
			memberDAO.deleteMember(id);
		}

		// 회원 목록을 출력
		printMemberList(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 전송한 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// 클라이언트에서 전송한 값을 구해옴
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		// 클라이언트에서 전송한 값을 검사한 다음 유효한 값인 경우 추가
		if (account != null && passwd != null && name != null && email != null) {
			// 클라이언트에서 전송한 값을 저장할 MemberVO 객체 생성
			MemberVO member = new MemberVO(0, account, passwd, name, email, null);

			// 새로운 회원을 등록하기 위해 MemberDAO 객체 생성
			MemberDAO memberDAO = new MemberDAO();

			// 새로운 회원을 등록
			memberDAO.insertMember(member);
		}

		// 회원 목록을 출력
		printMemberList(request, response);
	}

	protected void printMemberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// HttpServletResponse 객체의 getWriter 메서드를 이용해 출력 스트림의 PrintWriter
		// 객체를 받아옴
		PrintWriter out = response.getWriter();
		
		// 오라클 데이터베이스에 연결해서 member 테이블을 조회하기 위해 MemberDAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();

		// MemberDAO 객체의 getMemberList 메서드를 이용해, member 테이블을 조회
		List<MemberVO> list = memberDAO.getMemberList();

		// 클라이언트에 출력할 데이터
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\"><title>Member List</title>"
				+ "</head><body><h1>Member List</h1><table border=\"1\"><thead><tr>"
				+ "<th>ID</th><th>Account</th><th>Password</th><th>Name</th>"
				+ "<th>Email</th><th>Registration Date</th><th>Delete</th></tr></thead><tbody>";

		// ArrayList 객체에 저장된 MemberVO 객체에서 데이터를 가져와서 표를 생성
		for (MemberVO member : list)
			output += "<tr><td>" + member.getId() + "</td>"
					+ "<td>" + member.getAccount() + "</td>"
					+ "<td>" + member.getPasswd() + "</td>"
					+ "<td>" + member.getName() + "</td>"
					+ "<td>" + member.getEmail() + "</td>"
					+ "<td>" + member.getRegdate() + "</td>"
					+ "<td><a href=\"/pro04/member4?command=delete&id=" + member.getId()
					+ "\">[X]</a></td></tr>";

		output += "</tbody></table>"
				+ "<p><a href=\"/pro04/memberForm.html\">Membership Registration Form</a></p>"
				+ "</body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
