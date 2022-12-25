package ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multi-input2")
public class MultiInputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("CALL: MultiInputServlet2#init()");
	}

	public void destroy() {
		System.out.println("CALL: MultiInputServlet2#destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: MultiInputServlet2#doGet()");

		// 클라이언트에서 전송한 데이터의 문자 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// HttpServletRequest 객체의 getParameterNames 메서드를 이용해, 클라이언트에서
		// 전송한 데이터들의 name 속성들을 추출
		Enumeration<String> names = request.getParameterNames();
		
		// 반복자(iterator)를 이용해, 객체 names에서 값을 하나씩 추출
		while (names.hasMoreElements()) {
			// 객체 names에서 현재 참조하고 있는 값을 추출
			String name = names.nextElement();
			
			// 같은 name 속성을 갖는 2개 이상의 데이터를 참조할 때는 HttpServletRequest
			// 객체의 getParameterValues 메서드를 이용한다. 이 메서드는 String[]을 반환한다.
			String[] values = request.getParameterValues(name);

			// for-each 구문을 이용해 배열 values의 원소들을 차례대로 확인
			for (String value : values)
				System.out.printf("name = %s, value = %s\n", name, value);
		}
	}
}
