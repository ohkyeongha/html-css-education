<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IMAGE BOARD</title>
</head>
<body>
	<h1>이미지 게시 글 등록</h1>
	<form action="${path }/main/imgboard-regist" method="post" enctype="multipart/form-data">
		<div><textarea rows="5" cols="20" name="content"></textarea></div>
		<div><input type="file" name="uploadfile"></div>
		<div><input type="submit" name="" value="등록"></div>
	</form>
</body>
</html>