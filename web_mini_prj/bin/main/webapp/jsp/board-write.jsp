<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
<link rel="stylesheet" href="../css/board-write-style.css">
<script type="text/javascript" src="../js/board-write-script"></script>
</head>
<body>
	<h1>글 쓰기</h1>
	<form action="board-write-process.jsp" method="post" name ="boardWriteForm">
	<div id="writearea">
		<div id = "write-box">
			<div id = "title">
				<span>제목</span><br>
				<input id="input-title" type="text" id ="bTitle" required>
			</div>
			<div id = "writer" >
				<span>작성자</span>
				<input id="input-title" type="text" readonly>
			</div>
			<div id = "content">
				<span>내용</span><br>
				<textarea rows="15" id ="bContent" required></textarea>
			</div>
			<div id ="buttons">
				<input type="button" id="board-save-btn" value ="저장">
				<input type="button" id="board-cancle-btn" value ="취소">
			</div>
		</div>
	</div>
	</form>
</body>
</html>