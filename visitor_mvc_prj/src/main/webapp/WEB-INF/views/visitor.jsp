<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<h1>방명록</h1>
	<form action="" method="post">
		<input type="hidden" name="nickname" value="${nickname }">
		<textarea rows="5" cols="60" name="content"></textarea><br>
		<input type="submit" vlaue="등록">
	</form>
</body>
</html>