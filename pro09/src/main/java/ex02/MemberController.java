package ex02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Model 역할을 수행할 MemberDAO 객체를 필드로 추가
	private MemberDAO memberDAO;

	public void init(ServletConfig config) throws ServletException {
		// 서블릿 컨테이너에서 MemberController 객체를 생성할 때, MemberDAO 객체를 생성
		memberDAO = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에 응답하기 위해 포워딩할, 즉 View로 사용할 JSP 페이지
		// 우선 기본 값으로 listMembers로 설정하고, 나중에 요청에 따라 다시 설정
		String viewPage = "listMembers";

		// 요청 URL에서 요청 경로(path info)를 구해온다.
		// 요청 경로에 따라 실행할 기능이 결정된다.
		String action = request.getPathInfo();
		System.out.println("action: " + action);

		// 요청 경로(path info)에 따라 필요한 기능을 수행
		if (action.equals("/registerForm.do")) {
			// View로 사용할 JSP 페이지를 설정
			viewPage = "memberForm";
		}
		else if (action.equals("/registerMember.do")) {
			// TODO: POST 방식으로 들어온 요청인지 확인하고 처리해야 한다.
			// TODO: account나 email처럼 중복되면 안 되는 컬럼은 꼭 확인해야 한다!

			// 클라이언트에서 전송한 데이터를 이용해 MemberVO 객체 생성
			MemberVO member = new MemberVO(
					0,
					request.getParameter("account"),
					request.getParameter("passwd"),
					request.getParameter("name"),
					request.getParameter("email"),
					null);

			// MemberVO 객체를 member 테이블에 추가
			memberDAO.insertMember(member);

			// TODO: 새로운 레코드가 제대로 추가됐는지 확인해야 한다!

			// JSP 페이지에 전달할 메시지를 HttpServletRequest 객체에 바인딩
			request.setAttribute("message", "registerMember");

			// View로 사용할 JSP 페이지를 설정
			viewPage = "listMembers";
		}
		else if (action.equals("/updateForm.do")) {
			// 클라이언트에서 전송한 데이터를 읽어온다.
			String account = request.getParameter("account");

			// TODO: account 정보가 member 테이블에 존재하는지부터 확인해야 한다!

			// member 테이블에서 회원 정보를 조회
			MemberVO member = memberDAO.getMember(account);

			// JSP 페이지에서 활용하기 위해 회원 정보를 HttpServletRequest 객체에 바인딩
			request.setAttribute("member", member);

			// View로 사용할 JSP 페이지를 설정
			viewPage = "memberForm";
		}
		else if (action.equals("/updateMember.do")) {
			// TODO: POST 방식으로 들어온 요청인지 확인하고 처리해야 한다.
			// TODO: account 정보가 member 테이블에 존재하는지부터 확인해야 한다!
			// TODO: 갱신하고자 하는 email 정보가 다른 레코드와 중복되는지 확인해야 한다!

			// 클라이언트에서 전송한 데이터를 이용해 MemberVO 객체 생성
			MemberVO member = new MemberVO(
					0,
					request.getParameter("account"),
					request.getParameter("passwd"),
					request.getParameter("name"),
					request.getParameter("email"),
					null);

			// MemberDAO 객체의 udpateMember 메서드를 이용해, member 테이블의 레코드를 갱신
			memberDAO.updateMember(member);

			// TODO: 새로운 레코드가 제대로 갱신됐는지 확인해야 한다!

			// JSP 페이지에 전달할 메시지를 HttpServletRequest 객체에 바인딩
			request.setAttribute("message", "updateMember");

			// View로 사용할 JSP 페이지를 설정
			viewPage = "listMembers";
		}
		else if (action.equals("/deleteMember.do")) {
			// 클라이언트에서 전송한 데이터를 읽어온다.
			String id = request.getParameter("id");

			// TODO: member 테이블에서 id 컬럼을 가지는 레코드가 있는지 확인해야 한다.

			// member 테이블에서 주어진 id 컬럼으로 회원 정보를 삭제
			memberDAO.deleteMember(id);

			// JSP 페이지에 전달할 메시지를 HttpServletRequest 객체에 바인딩
			request.setAttribute("message", "deleteMember");

			// View로 사용할 JSP 페이지를 설정
			viewPage = "listMembers";
		}

		// 회원 목록을 출력해야 하는 경우, 즉 포워딩할 JSP 페이지가 "listMembers"인 경우
		if (viewPage.equals("listMembers")) {
			// MemberDAO 객체의 getMemberList 메서드를 이용해, 회원 목록을 구해온다.
			List<MemberVO> memberList = memberDAO.getMemberList();

			// listMembers.jsp에서 접근할 수 있도록 HttpServletRequest 객체에 바인딩
			request.setAttribute("memberList", memberList);
		}

		// 포워딩할 JSP 페이지의 URI 생성
		// String viewPageURI = request.getContextPath() + "/" + viewPage + ".jsp";
		String viewPageURI = "/ex02/" + viewPage + ".jsp";

		// RequestDispatcher 객체의 forward 메서드를 이용해, View로 사용할 JSP 페이지로 포워딩
		request.getRequestDispatcher(viewPageURI).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식의 요청은 doPost 메서드에서 처리하는 게 옳지만, 여기에서는
		// doGet 메서드에서 같이 처리하도록 작성한다.
		// 실무에서 이런 짓을 하면 선배들한테 혼난다! 난 분명 말했다!
		doGet(request, response);
	}
}
