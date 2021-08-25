<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM</title>
</head>
<body>
		<h1>회원가입</h1>
		<form action="join" method="post">
			ID: 	<input type="text" name="id"><br>
			PW:		<input type="password" name="pw"><br>
			이름: 	<input type="text" name="name"><br>
			주소: 	<input type="text" name="address"><br>
			전화번호: <input type="text" name="phone"><br>
			email: 	<input type="text" name="email"><br>
			성별: 	<input type="radio" name="gender" value="mail">남
				 	<input type="radio" name="gender" value="femail">여 <br>
			취미: 	<input type="checkbox" name="hobby" value="game"> 게임
				 	<input type="checkbox" name="hobby" value="sport"> 운동
				 	<input type="checkbox" name="hobby" value="reading"> 독서<br>
					<input type="submit" value="가입">
		</form>
</body>
</html>