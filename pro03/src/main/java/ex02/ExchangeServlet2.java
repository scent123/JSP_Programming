package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exchange2")
public class ExchangeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 환율 정보를 담고 있는 정적 상수
	private static final double USD_RATE = 0.00084;
	private static final double EUR_RATE = 0.00072;
	private static final double JPY_RATE = 0.095;
	private static final double CNY_RATE = 0.0054;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("CALL: ExchangeServlet2#init()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: ExchangeServlet2#doGet()");
		
		// 클라이언트에서 전송한 데이터의 문자 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// 클라이언트에서 전송된 값을 참조
		String krw = request.getParameter("krw");
		String currency = request.getParameter("currency");
		String command = request.getParameter("command");

		// 응답할 데이터의 미디어 형식 설정
		response.setContentType("text/html; charset=utf-8");

		// PrintWriter 객체 생성
		PrintWriter out = response.getWriter();

		// 클라이언트에 출력할 데이터 생성
		String output = "<!DOCTYPE html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Currency Exchange Calculation</title></head>"
				+ "<body><h1>Currency Exchange Calculation</h1>";

		// 입력 양식에서 값을 전송한 경우, 환전 금액을 계산해서 출력
		// → hidden 입력 요소인 command 속성에 값이 전달되고, 값이 "calculate"인 경우
		// if (command != null && command == "calculate")		// WRONG!
		if (command != null && command.equals("calculate")) {
			// 환전 금액을 저장할 변수
			double amount = 0;

			// 환전할 통화에 따라 환전 금액을 계산
			if (currency.equals("usd"))
				amount = Integer.parseInt(krw) * USD_RATE;
			else if (currency.equals("eur"))
				amount = Integer.parseInt(krw) * EUR_RATE;
			else if (currency.equals("jpy"))
				amount = Integer.parseInt(krw) * JPY_RATE;
			else if (currency.equals("cny"))
				amount = Integer.parseInt(krw) * CNY_RATE;

			// 클라이언트에 출력할 데이터를 추가
			// <p>KRW 10000 = USD 9.82</p>
			output += String.format("<p>KRW %s = %s %.2f</p>",
					krw, currency.toUpperCase(), amount);
		}

		// 출력할 데이터에 입력 양식을 추가
		output += "<form action=\"exchange2\" method=\"get\">"
				+ "<input type=\"hidden\" name=\"command\" value=\"calculate\">"
				+ "KRW <input type=\"text\" name=\"krw\"> to <select name=\"currency\">"
				+ "<option value=\"usd\">US Dollar</option>"
				+ "<option value=\"eur\">Euro</option>"
				+ "<option value=\"jpy\">Japan Yen</option>"
				+ "<option value=\"cny\">China Yuan</option></select> "
				+ "<input type=\"submit\" name=\"calc\" value=\"Calculate\"></form>";

		output += "</body></html>";

		// PrintWriter 객체의 print 메서드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);

		// 출력 스트림(output stream) 닫기
		out.close();
	}
}
