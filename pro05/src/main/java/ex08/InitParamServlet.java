package ex08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { 
				"/init-param", 
				"/init"
		}, 
		initParams = { 
				@WebInitParam(name = "container", value = "Apache Tomcat 9.0"), 
				@WebInitParam(name = "database", value = "Oracle Database 21c XE")
		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		// setContentType 메서드는 HttpServletResponse 객체의 getWriter 메서드를 호출하기
		// 전에 호출해야 한다.
		response.setContentType("text/html; charset=utf-8");

		// HttpServletResponse 객체의 getWriter 메서드를 이용해 출력 스트림의
		// PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();

		// GenericServlet 클래스의 getInitParameter 메서드를 이용해 초기화 매개변수를 가져옴
		String container = getInitParameter("container");
		String database = getInitParameter("database");

		// 클라이언트에 응답할 데이터를 생성
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Initialization Parameter</title></head>"
				+ "<body><h1>Initialization Parameter</h1>"
				+ "<ul><li>Container: " + container + "</li>"
				+ "<li>Database: " + database + "</li></ul>"
				+ "</body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
