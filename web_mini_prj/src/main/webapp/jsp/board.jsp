<%@page import="com.kitri.miniboard.board.BoardDAO"%>
<%@page import="com.kitri.miniboard.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BoardDAO bdao = new BoardDAO();
	List<BoardVO> blist = bdao.selectBoardList();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<link rel="stylesheet" href="../css/board-style.css">
</head>
<body>
	<header>
		<h1>게시판</h1>
		<a href = "board-write.jsp"> 글 등록 </a>
	</header>
	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
		
			<%
			
				for(BoardVO bvo: blist){
					out.print("<tr>");
					out.print("	<td>" + bvo.getBno() + "</td>");
					out.print("	<td>" + bvo.getbTitle() + "</td>");
					out.print("	<td>" + bvo.getbWriter() + "</td>");
					out.print("	<td>" + bvo.getbRegDate() + "</td>");
					out.print("</tr>");
				}
			
			%> 
		</tbody>
	</table>
</body>
</html>