package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multi-input")
public class MultiInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("CALL: MultiInputServlet#init()");
	}

	public void destroy() {
		System.out.println("CALL: MultiInputServlet#destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: MultiInputServlet#doGet()");

		// 클라이언트에서 전송한 데이터의 문자 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// 같은 name 속성을 갖는 여러 데이터를 참조할 때는 HttpServletRequest 객체의
		// getParameterValues 메서드를 이용한다. 이 메서드는 String[]을 반환한다.
		String[] subjects = request.getParameterValues("subject");
		
		// 반복문을 이용해, 배열 subjects의 값들을 차례대로 확인
		for (String item : subjects)
			System.out.println("Subject: " + item);

	}
}
