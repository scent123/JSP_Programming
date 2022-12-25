package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 전송한 데이터의 문자 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// HttpServletRequest 객체의 getCookies 메서드를 이용해 쿠키를 가져옴
		Cookie[] cookies = request.getCookies();

		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// HttpServletResponse 객체의 getWriter 메서드를 이용해 출력 스트림의
		// PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();

		// 클라이언트에 전송할 데이터를 HTML 형식으로 생성
		String output = "<!DOCTYPE html>\r\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Get Cookie</title></head>"
				+ "<body><h1>Get Cookie</h1><ul>";

		// Cookie 객체의 배열에서 쿠키를 차례대로 확인
		for (Cookie cookie : cookies)
			output += "<li>" + cookie.getName() + " = \""
					+ URLDecoder.decode(cookie.getValue(), "utf-8") + "\"</li>";

		output += "</ul></body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
