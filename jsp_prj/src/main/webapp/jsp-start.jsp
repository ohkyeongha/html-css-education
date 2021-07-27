<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!   //선언문
   /*
      변수 선언 및 초기화
      메소드 작성
   */
   String name = "가갸";
   public void method(){
      System.out.println("출력");
   }
%>
<%
   /*
      스크립트릿
      -자바문 적는 곳
   */
   System.out.println(name);
   method();

%>
<!--     표현식 -->
<%=name %>
<!--    -HTML 출력하기 위한 자바문 -->
<%-- <% String val = "자바문";%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Insert title here</title>
</head>
<body>
   <h1><%=name %></h1>
</body>
</html>