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
		request.setCharacterEncoding("utf-8");
		
		Cookie[] cookies = request.getCookies();
		String id = "";
		String checked = "";
		for(int i=0 ; cookies != null && i < cookies.length ; i++){
			if(cookies[i].getName().equals("idcheck")){
				id=cookies[i].getValue();	//쿠키에 담은 ID값
				checked="checked";
			}
		}
		String msg = (String)request.getAttribute("msg");
		   if(msg==null) {
		      msg = "";
		   }
	
	%>
	<fieldset>
		<form action="cookie.jsp" method="post">
			<label> ID : <input type="text" name="id" value="<%=id%>"></label><br>
			<label> PW : <input type="password" name="pw"></label><br>
			<span style="color:red"><%=msg %></span><br>
			<label> <input type="checkbox" name = "idcheck" value="idcheck" <%=checked %>>ID 기억 </label>
			<input type="submit" value="로그인">
		</form>
	</fieldset>
</body>
</html>