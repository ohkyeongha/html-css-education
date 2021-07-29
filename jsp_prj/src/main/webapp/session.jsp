<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션 객체 생성
// 	HttpSession session =  request.getSession(); //세션 객체를 생성하기 위함(jsessionid(브라우저의 id)가져오는 역할)
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	if(id.equals("admin") && pw.equals("1234")){
		//로그인 성공
		//세션값 생성
		session.setAttribute("id", id);
		response.sendRedirect("login-ok.jsp");
	} else{
		//로그인 실패
		response.sendRedirect("login-session.jsp");
	}
	//세션 값 생성
	
%>