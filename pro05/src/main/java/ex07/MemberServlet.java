package ex07;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 오라클 데이터베이스에 연결해서 member 테이블을 조회하기 위해 MemberDAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();

		// MemberDAO 객체의 getMemberList 메서드를 이용해, member 테이블을 조회
		List<MemberVO> memberList = memberDAO.getMemberList();

		// HttpServletRequest 객체에 회원 목록을 바인딩
		request.setAttribute("memberList", memberList);

		// RequestDispatcher 객체를 생성하고, forward 메서드를 이용해 viewMemberList로 포워딩
		RequestDispatcher dispatch = request.getRequestDispatcher("viewMemberList");
		dispatch.forward(request, response);
	}
}
