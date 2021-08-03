<%@page import="com.kitri.miniboard.board.BoardDAO"%>
<%@page import="com.kitri.miniboard.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//글 등록
	String bTitle = request.getParameter("bTitle");
	String bContent = request.getParameter("bContent");
	String bWriter = (String)session.getAttribute("userId");
	
	BoardVO bvo = new BoardVO();
	bvo.setbTitle(bTitle);
	bvo.setbContent(bContent);
	bvo.setbWriter(bWriter);
	
	BoardDAO bdao = new BoardDAO();
	//insert
	int result = bdao.insertBoard(bvo);				
	
	if(result != 0){
		//정상적으로 insert
		msg = "글이 정상적으로 등록되었습니다."
		//board.jsp
		response.sendRedirect("board.jsp");
	} else {
		//insert 안됨
		//board-write.jsp
		
	}
%>