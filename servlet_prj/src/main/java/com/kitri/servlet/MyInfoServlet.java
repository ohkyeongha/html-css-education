package com.kitri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/MyInfoServlet")
public class MyInfoServlet extends HttpServlet {
	
//    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//    	
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nichname = request.getParameter("nichname");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		int age = Integer.parseInt(request.getParameter("age"));
		String myintro = request.getParameter("myintro");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>내 정보 페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>내정보</h1>");
		out.println("	<div>");
		out.println("	이름 : " + name + "<br>");
		out.println("	ID : " + id + "<br>");
		out.println("	PW : " + pw + "<br>");
		out.println("	성별 : " + gender+ "<br>");
		out.println("	나이 : " + age + "<br>");
		out.print("	취미 : ");
		for (int i = 0; i < hobby.length; i++) {
			out.print(hobby[i] + " ");
		}
		out.println("<br>");
		
		out.println("	자기소개 : " + myintro);
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nichname = request.getParameter("nichname");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		int age = Integer.parseInt(request.getParameter("age"));
		String myintro = request.getParameter("myintro");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>내 정보 페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>내정보</h1>");
		out.println("	<div>");
		out.println("	이름 : " + name + "<br>");
		out.println("	ID : " + id + "<br>");
		out.println("	PW : " + pw + "<br>");
		out.println("	성별 : " + gender+ "<br>");
		out.println("	나이 : " + age + "<br>");
		out.print("	취미 : ");
		for (int i = 0; i < hobby.length; i++) {
			out.print(hobby[i] + " ");
		}
		out.println("<br>");
		
		out.println("	자기소개 : " + myintro);
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
