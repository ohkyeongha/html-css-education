<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>데이터 출력</h1>
<%-- 	id : ${id } <br> --%>
<%-- 	name: ${name} --%>
	
	<!-- 모델 전체 값 가져오는 방식의 el -->
	id : ${mvo.id } <br>
	name: ${mvo.name}
	
</body>
</html>