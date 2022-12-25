package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");

		// HttpServletResponse 객체의 getWriter 메서드를 이용해 출력 스트림의
		// PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();

		// 쿠키의 이름과 값
		String name = "course";
		String value = "JSP Programming";

		// Cookie 객체 생성
		// → 쿠키는 HTTP 헤더에 추가되어 전송되므로, 쿠키 값에 한글이나 빈칸, 특수 문자 등이
		//   포함된 경우에는 반드시 인코딩해야 한다. 이때 URLEncoder 클래스의 encode 메서드를
		//   이용한다.
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));

		// 쿠키의 유효 기간을 초 단위로 설정
		// → 유효 기간을 설정하면 영구 쿠키(persistence cookie)로 저장된다.
		cookie.setMaxAge(24 * 60 * 60);

		// HttpServletResponse 객체에 쿠키 추가
		response.addCookie(cookie);

		// 디버그 메시지
		System.out.println("COOKIE: " + cookie);

		// 클라이언트에 전송할 데이터를 HTML 형식으로 생성
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Set Cookie</title></head>"
				+ "<body><h1>Set Cookie</h1>"
				+ "<ul><li>Cookie Name: " + name + "</li>"
				+ "<li>Cookie value: " + value + "</li></ul>"
				+ "<p><a href=\"getCookie\">Go to the Get-Cookie page!</a></p>"
				+ "</body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
