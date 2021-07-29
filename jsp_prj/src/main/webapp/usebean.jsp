<%@page import="com.kitri.javabean.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<% --%>
<!--  		StudentVO student = new StudentVO(); -->
	
<!--  		student.setName("학생1"); -->
<!--  		student.setAge(19); -->
<!-- 		student.setBan("1반"); -->
		
<!-- 		String name = student.getName(); -->
<!--  		int age = student.getAge(); -->
<!--  		String ban = student.getBan(); -->
		
<!--  		out.print("<h1> 이름 : " + name + "</h1>"); -->
<!--  		out.print("<h1> 나이 : " + age + "</h1>"); -->
<!--  		out.print("<h1> 반 : " + ban + "</h1>"); -->
<%-- 	%> --%>

<%-- 	<jsp:useBean id="student" class="com.kitri.javabean.StudentVO"/> --%>
	
<%-- 	<jsp:setProperty property="name" name="student" value="학생1"/> --%>
<%-- 	<jsp:setProperty property="age" name="student" value="18"/> --%>
<%-- 	<jsp:setProperty property="ban" name="student" value="1반"/> --%>
	
<%-- 	<h1> 이름 : <jsp:getProperty property="name" name="student"/></h1> --%>
<%-- 	<h1> 나이 : <jsp:getProperty property="age" name="student"/></h1> --%>
<%-- 	<h1> 반 : <jsp:getProperty property="ban" name="student"/></h1> --%>

	<jsp:useBean id="student" class="com.kitri.javabean.StudentVO"/>
	
	<jsp:setProperty property="*" name="student"/>
<%-- 	<jsp:setProperty property="name" name="student"/> --%>
<%-- 	<jsp:setProperty property="age" name="student"/> --%>
<%-- 	<jsp:setProperty property="ban" name="student"/> --%>
	
	<h1> 이름 : <jsp:getProperty property="name" name="student"/></h1>
	<h1> 나이 : <jsp:getProperty property="age" name="student"/></h1>
	<h1> 반 : <jsp:getProperty property="ban" name="student"/></h1>
	
	
	
</body>
</html>