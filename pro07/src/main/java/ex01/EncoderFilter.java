package ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncoderFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = -7705705937726835789L;

	// ServletContext 객체
	ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CALL: EncoderFilter#init()");

		// FilterConfig 객체의 getServletContext 메서드를 이용해 ServletContext 객체를
		// 받아옴
		context = fConfig.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("CALL: EncoderFilter#doFilter()");

		/*
		 * 요청 필터 기능
		 */

		// 클라이언트에서 전송한 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// 컨텍스트 경로
		String contextPath = ((HttpServletRequest)request).getContextPath();

		// 클라이언트가 요청한 URI
		String uri = ((HttpServletRequest)request).getRequestURI();

		System.out.println("Context path: " + contextPath);
		System.out.println("Request URI: " + uri);

		// 요청 필터에서 서블릿에서 요청 처리를 하기 전의 시각을 구함
		long start = System.currentTimeMillis();

		// 필터 체인에 있는 다음 필터로 요청을 전달
		// → 이 문장을 기준으로 위쪽은 요청 필터 기능을, 아래쪽은 응답 필터 기능을 수행한다.
		chain.doFilter(request, response);

		/*
		 * 응답 필터 기능
		 */

		// 응답 필터에서 서블릿에서 요청 처리를 끝낸 다음의 시각을 구함
		long end = System.currentTimeMillis();

		System.out.println("Running time: " + (end - start) + "ms");
	}

	public void destroy() {
		System.out.println("CALL: EncoderFilter#destroy()");
	}
}
