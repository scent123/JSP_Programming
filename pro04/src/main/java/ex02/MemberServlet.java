package ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member2")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				+ "<th>Email</th><th>Registration Date</th></tr></thead><tbody>";

		// ArrayList 객체에 저장된 MemberVO 객체에서 데이터를 가져와서 표를 생성
		for (MemberVO member : list)
			output += "<tr><td>" + member.getId() + "</td>"
					+ "<td>" + member.getAccount() + "</td>"
					+ "<td>" + member.getPasswd() + "</td>"
					+ "<td>" + member.getName() + "</td>"
					+ "<td>" + member.getEmail() + "</td>"
					+ "<td>" + member.getRegdate() + "</td></tr>";

		output += "</tbody></table></body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
