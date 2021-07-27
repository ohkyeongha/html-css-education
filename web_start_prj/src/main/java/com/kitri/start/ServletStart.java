package com.kitri.start;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/start")
public class ServletStart extends HttpServlet {
	
	public ServletStart() {
		System.out.println("ServletStart 클래스 객체 생성");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("ServletStart init 메소드 호출");
	}
	@Override
	public void destroy() {
		System.out.println("ServletStart destroy 메소드 호출");
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* get방식
		 *  - url을 통해 호출
		 *  - form태그 method 속성값을 get으로 지정하여 호출
		 *  - url을 사용하여 값을 전송하기 때문에 보안에 취약
		 *  - 빠름
		 */
		
		//query값을 가져오는 메소드
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		
		System.out.println("doGet 메소드 호출");
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>start 페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1> Servlet start 페이지 </h1>");
		out.println("	<p> get 방식 호출 </p>");
		out.println("	<div> name : " + name + " </div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/* post 방식
	 *  - form태그 method 속성값을 post로 지정하여 호출
	 *  - 값을 url에 보내지 않고 http 프로토콜의 header에 실어서 보내 보안에 좋음
	 *  - get보단 느림
	 */
		System.out.println("doPost 메소드 호출");
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		doGet(request, response);
	}

}
