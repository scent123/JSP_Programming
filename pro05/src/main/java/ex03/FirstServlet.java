package ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first3")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// 출력 스트림의 PrintWriter 객체를 생성
		PrintWriter out = response.getWriter();

		// 클라이언트에 출력할 데이터
		// → JavaScript 프로그램에서 location 객체의 href 속성을 설정해서 포워딩
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Location Forward Test</title>"
				+ "<script> location.href = \"second3\"; </script></head>"
				+ "<body><h1>Location Forward Test</h1>"
				+ "<p>This is the first servlet!</p></body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
