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

@WebServlet("/setContext")
public class SetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		// setContentType 메서드는 HttpServletResponse 객체의 getWriter 메서드를 호출하기
		// 전에 호출해야 한다.
		response.setContentType("text/html; charset=utf-8");

		// HttpServletResponse 객체의 getWriter 메서드를 이용해 출력 스트림의
		// PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();

		// ServletContext 객체에 바인딩할 ArrayList 객체 생성
		List<String> members = new ArrayList<String>();
		members.add("Harry Potter");
		members.add("Clark Kent");

		// GenericServlet 클래스의 getServletContext 메서드를 이용해 ServletContext 객체를
		// 가져옴
		ServletContext context = getServletContext();

		// ServletContext 객체의 setAttribute 메서드를 이용해 ArrayList 객체를 바인딩
		context.setAttribute("members", members);

		// 클라이언트에 응답할 데이터를 생성
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Set ServletContext</title></head>"
				+ "<body><h1>Set ServletContext</h1>"
				+ "<ul><li>" + members.get(0) + "</li><li>" + members.get(1) + "</li></ul>"
				+ "</body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
