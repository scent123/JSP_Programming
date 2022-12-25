package ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second5")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 전송할 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// 클라이언트에서 전송한 값을 구해옴
		// → 여기에 전달되는 값은 first5 서블릿에서 포워딩 하면서 추가한 값이다.
		String name = request.getParameter("name");

		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// 출력 스트림의 PrintWriter 객체를 생성
		PrintWriter out = response.getWriter();

		// 클라이언트에 출력할 데이터
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Dispatch Forward Test</title></head>"
				+ "<body><h1>Dispatch Forward Test</h1>"
				+ "<p>This is the second servlet!</p>"
				+ "<ul><li>Name : " + name + "</li></ul></body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
