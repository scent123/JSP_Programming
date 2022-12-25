package ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("CALL: SecondServlet#init()");
	}

	@Override
	public void destroy() {
		System.out.println("CALL: SecondServlet#destroy()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("CALL: SecondServlet#doGet()");
	}
}
