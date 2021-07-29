<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="logout.js" type="text/javascript">
	
</script>
</head>
<body>
	<h1>로그인 성공</h1>
	<%
		String id = (String)session.getAttribute("id");
		if(id == null){
			id="null";
		}
 	%>
 	<h2>session : <%=id %></h2>
 	<button id = "logoutBtn">로그아웃</button>
</body>
</html>