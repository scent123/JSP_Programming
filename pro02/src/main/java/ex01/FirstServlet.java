package ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet {
	// init 메서드: 서블릿 요청 시 한 번만 실행되며, 초기화 작업을 수행
	@Override
	public void init() throws ServletException {
		System.out.println("CALL: FirstServlet#init()");
	}

	// destroy 메서드: 서블릿이 소멸될 때 호출되며, 마무리 작업을 수행
	@Override
	public void destroy() {
		System.out.println("CALL: FirstServlet#destroy()");
	}

	// doGet 메서드: 서블릿 요청 시 매번 실행되며, 요청한 작업을 수행
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("CALL: FirstServlet#doGet()");
	}
}
