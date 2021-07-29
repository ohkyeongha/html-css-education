<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
<link rel="stylesheet" href="../css/board-write-style.css">
</head>
<body>
	<h1>글 쓰기</h1>
	<div id="writearea">
		<div id = "write-box">
			<div id = "title">
				<span>제목</span><br>
				<input id="input-title" type="text">
			</div>
			<div id = "writer">
				<span>작성자</span>
			</div>
			<div id = "content">
				<span>내용</span><br>
				<textarea rows="15"></textarea>
			</div>
			<div id ="buttons">
				<button>저장</button>
				<button>취소</button>
			</div>
		</div>
	</div>
</body>
</html>