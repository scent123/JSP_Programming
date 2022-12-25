package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("CALL: LoginServlet#init()");
	}

	public void destroy() {
		System.out.println("CALL: LoginServlet#destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: LoginServlet#doGet()");

		// 클라이언트에서 전송한 데이터의 문자 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// HttpServletRequest 객체의 getParameter 메서드를 이용해 클라이언트에서 전송한
		// 데이터를 참조
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		// 클라이언트에서 전송한 데이터를 출력
		System.out.println("Account: " + account);
		System.out.println("Password: " + password);
	}
}
