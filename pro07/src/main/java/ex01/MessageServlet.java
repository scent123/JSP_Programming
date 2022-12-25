package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 전송한 값을 구해옴
		String message = request.getParameter("message");

		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// 출력 스트림(output stream)의 PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();

		// 출력할 데이터를 HTML 형식으로 생성
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>메시지 입력</title></head>"
				+ "<body><h1>메시지 입력</h1>"
				+ "<p>당신의 메시지는 &quot;" + message + "&quot;입니다.</p>"
				+ "</body></html>";

		// 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림 닫기
		out.close();
	}
}
