package ex08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getContext")
public class GetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		// setContentType 메서드는 HttpServletResponse 객체의 getWriter 메서드를 호출하기
		// 전에 호출해야 한다.
		response.setContentType("text/html; charset=utf-8");

		// HttpServletResponse 객체의 getWriter 메서드를 이용해 출력 스트림의
		// PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();

		// GenericServlet 클래스의 getServletContext 메서드를 이용해 ServletContext 객체를
		// 가져옴
		ServletContext context = getServletContext();

		// ServletContext 객체의 getAttribute 메서드를 이용해 바인딩된 자원을 가져옴
		List<?> members = (ArrayList<?>)context.getAttribute("members");

		// 클라이언트에 응답할 데이터를 생성
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Get ServletContext</title></head>"
				+ "<body><h1>Get ServletContext</h1>"
				+ "<ul><li>" + (String)members.get(0) + "</li><li>" + (String)members.get(1) + "</li></ul>"
				+ "</body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
