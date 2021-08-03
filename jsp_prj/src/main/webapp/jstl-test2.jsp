<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	List<String> list = new ArrayList<String>();
	list.add("문자1");
	list.add("문자2");
	list.add("문자3");
	list.add("문자4");

	request.setAttribute("list", list);
	
	RequestDispatcher rd = request.getRequestDispatcher("jstl-test.jsp");
	rd.forward(request, response);
%>
