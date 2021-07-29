<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- forward, include, param 엑션 태그 -->
	<h1>action-tag 페이지 상단</h1>
	<%-- <%
		RequestDispatcher rd = request.getRequestDispatcher("next-page.jsp");
		rd.forward(request, response);
	%> --%>
<%-- 	<jsp:forward page="next-page.jsp"></jsp:forward> --%>

	<%
		String str = "action-tag 변수";
	%>
	
	<!-- include지시자는 html파일을 다 가져와서 넣어주는 역할 -->
	<%@ include file="next-page.jsp" %>
	
	<!-- include 액션태그는 렌더링 된 내용을 가져와서 넣어주는 역할 -->
<%-- 	<jsp:include page="next-page.jsp"></jsp:include> --%>
	<h1>action-tag 페이지 하단</h1>
	<h2><%= str %></h2>
	
</body>
</html>