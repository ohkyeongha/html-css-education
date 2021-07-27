// com.kitri.servlet/DispatcherServlet.java

package com.kitri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div>Dispatcher Servlet<div>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("DB connect");
		System.out.println("DB Search");
		
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("dispatcher-html.html");
		 * rd.include(request, response);
		 */
		
		response.sendRedirect("dispatcher-html.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
