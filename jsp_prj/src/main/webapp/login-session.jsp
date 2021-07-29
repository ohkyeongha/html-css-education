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
		
	
	%>
	<fieldset>
		<form action="session.jsp" method="post">
			<label> ID : <input type="text" name="id"></label><br>
			<label> PW : <input type="password" name="pw"></label><br>
<%-- 			<span style="color:red"><%=msg %></span><br> --%>
<!-- 			<label> <input type="checkbox" name = "idcheck" value="idcheck">ID 기억 </label> -->
			<input type="submit" value="로그인">
		</form>
	</fieldset>
</body>
</html>