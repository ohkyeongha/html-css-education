<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		out.print("java name : " + name + "<br>");
		out.print("java id : " + id);
	%>
	<div>
		name : ${param.name }<br>
		id : ${param.id }
	</div>
</body>
</html>