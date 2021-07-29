<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>구구단</h2>
	<% for(int i = 2 ; i < 10 ; i++){ %>
	<table border='1' style='float:left'>
		
		<tr>
			<th colspan = "2"><%= i + "단" %></th>
		</tr>
		
		<tr>
			<th>식</th> 
			<th>결과값</th> 
		</tr>
		
		<% for(int j = 1 ; j < 10 ; j++){ %>
		<tr>
				<td><%= i + " x " + j %></td> 
				<td><%= i*j %></td> 
		</tr>
		<% } %>
	</table>
	<% } %>	
</body>
</html>