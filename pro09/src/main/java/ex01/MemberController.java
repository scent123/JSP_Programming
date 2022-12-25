package ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Model 역할을 수행할 MemberDAO 객체를 필드로 추가
	private MemberDAO memberDAO;

	public void init(ServletConfig config) throws ServletException {
		// 서블릿 컨테이너에서 MemberController 객체를 생성할 때, MemberDAO 객체를 생성
		memberDAO = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 목록을 클라이언트에게 응답하기 위해, MemberDAO 객체를 모델(Model)로 해서
		// 데이터베이스에서 회원 목록을 조회하고, 그 결과를 출력하기 위해 뷰(View)로
		// 사용할 listMembers.jsp에 회원 목록을 전달한다.

		// MemberDAO 객체의 getMemberList 메서드를 이용해 회원 목록을 구해온다.
		List<MemberVO> memberList = memberDAO.getMemberList();

		// listMembers.jsp에서 회원 목록에 접근할 수 있도록 HttpServletRequest 객체에 바인딩
		request.setAttribute("memberList", memberList);

		// RequestDispatcher 객체의 forward 메서드를 이용해 listMembers.jsp로 포워딩
		request.getRequestDispatcher("/ex01/listMembers.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
