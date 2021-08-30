<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="join-ok" method="post">
		아이디:<input type="text" name="id"><br>
		패스워드<input type="password" name="pw"><br>
		이름: <input type="text" name="name"><br>
		주소: <input type="text" name="address"><br>
		전화번호: <input type="text" name="phone"><br>
		email: <input type="text" name="email"><br>
		성별: <input type="radio" name="gender" value="male">남, 
			<input type="radio" name="gender" value="female">여<br>
		취미: <input type="checkbox" name="hobby" value="game">게임,
			<input type="checkbox" name="hobby" value="sports">운동,
			<input type="checkbox" name="hobby" value="read">독서 <br>
		
		<input type="submit" value="가입">
	
	
	</form>
</body>
</html>