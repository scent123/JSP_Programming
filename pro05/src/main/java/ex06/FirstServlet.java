package ex06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first6")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// HttpServletRequest 객체에 새로운 데이터를 바인딩
		request.setAttribute("name", "potter");

		// RequestDispatcher 객체의 forward 메서드를 이용해 second6 서블릿으로 포워딩
		RequestDispatcher dispatch = request.getRequestDispatcher("second6");
		dispatch.forward(request, response);
	}
}
