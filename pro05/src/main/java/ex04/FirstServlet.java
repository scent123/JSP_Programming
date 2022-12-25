package ex04;

import java.io.IOException;

// import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first4")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// RequestDispatcher 객체의 forward 메서드를 이용해 second4 서블릿으로 포워딩
		// RequestDispatcher dispatch = request.getRequestDispatcher("second4");
		// dispatch.forward(request, response);
		request.getRequestDispatcher("second4").forward(request, response);
	}
}
