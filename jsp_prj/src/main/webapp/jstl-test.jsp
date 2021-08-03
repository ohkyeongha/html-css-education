<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST</title>
</head>
<body>
	<c:set var="name" value="${param.name }"/>
	name : ${name }<br>
 	id : <c:out value="${param.id }" escapeXml="true"/><br>
	
	<c:if test="${name =='경하' }">
 		true 출력
	</c:if>
	
	<c:choose>
		<c:when test="${name eq 'kh' }">나</c:when>
		<c:when test="${name eq 'as' }">너</c:when>
		<c:otherwise>우리</c:otherwise>
	</c:choose>
	
   <br>
	
   <c:forEach var ="str" items = "${requestScope.list }" varStatus="status">
      ${str }, ${status.index }
   </c:forEach>
	<%--
		List<String> list = (List<String>)request.getAttribute("list");
		for(String str : list){
			out.print(str+"<br>");
		}
	
	--%>
	
	<c:forEach begin="1" end="10" var="i" step="1">
		${i }<br>
	</c:forEach>
	
	<%
		Date now = new Date();
	%>
	<fmt:formatDate value="<%=now %>" pattern="yyyy년 MM월 dd일 HH:mm:ss"/>
	
</body>
</html>