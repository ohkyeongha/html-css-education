<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% //자바문
   String name = request.getParameter("name");
   String age = request.getParameter("age");


%>
<body>
   <h1>내 정보</h1>
   <table border="1">
      <tr>
         <th>이름</th>
         <td><%=name %></td>
      </tr>
      <tr>
         <th>나이</th>
         <td><%=age %></td>
      </tr>
   </table>
</body>
</html>