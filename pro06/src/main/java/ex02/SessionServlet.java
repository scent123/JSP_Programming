package ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// 출력 스트림의 PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();

		// HttpServletRequest 객체의 getSession 메서드를 이용해 HttpSession 객체 생성
		HttpSession session = request.getSession();

		// 응답할 데이터를 HTML 형식으로 생성
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Session Test</title></head>"
				+ "<body><h1>Session Test</h1>";

		// HttpSession 객체의 isNew 메서드를 이용해, 새롭게 생성된 세션인지 확인
		if (session.isNew())
			output += "<p>A new session has been created.</p>";
		else
			output += "<p>Reuse the previously created session.</p>";

		// HttpSession 객체의 메서드들을 이용해, 세션과 관련된 정보 확인
		output += "<ul><li>Session ID: " + session.getId() + "</li>"
				+ "<li>Session creation time: " + new Date(session.getCreationTime()) + "</li>"
				+ "<li>Last session access time: " + new Date(session.getLastAccessedTime()) + "</li>"
				+ "<li>Session active interval: " + session.getMaxInactiveInterval() + " seconds</li>"
				+ "</ul></body></html>";

		// 출력 스트림에 데이터 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
