<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MultiFile Upload Page</title>
</head>
<body>
	<h1>다중 파일 업로드 페이지</h1>
	<form action="multifileupload" method="post" enctype="multipart/form-data">
		<input type="text" name="name"><br>
		<input type="file" name="uploadfile" multiple="multiple"><br>
		<input type="submit" name="UPLOAD">
	</form>
</body>
</html>