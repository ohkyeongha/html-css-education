<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	response.setContentType("text/html; charset=UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String idcheck = request.getParameter("idcheck");
	
	String msg = "";
	
	if(id.equals("admin") && pw.equals("1234")){
		//로그인 성공
		if(idcheck != null){
			//id 기억 체크
			Cookie cookie = new Cookie("idcheck", id);
			cookie.setMaxAge(100);
			cookie.setPath("/");
			response.addCookie(cookie);
		} else{
			//id 기억 체크 안함
			Cookie[] cookies = request.getCookies();
			for(int i = 0 ; (cookies != null) && (i < cookies.length) ; i++){
				if(cookies[i].getName().equals("idcheck")){
					cookies[i].setMaxAge(0);
					cookies[i].setPath("/");
					response.addCookie(cookies[i]);
				}
			}
		}
		response.sendRedirect("login-ok.jsp");
	} else {
		//로그인 실패
		msg = "ID 또는 Password가 맞지 않습니다.";
		URLEncoder.encode(msg, "UTF-8");
		
//      request에 값 실어서 전송하는 법
    	request.setAttribute("msg", msg);
     
//      response.sendRedirect("login.jsp?msg=" + msg);
     
     	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
     	rd.forward(request, response);
  }
%>