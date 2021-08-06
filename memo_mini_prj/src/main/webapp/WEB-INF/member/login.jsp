<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/login.css">
<script src="${pageContext.request.contextPath }/assets/js/login.js"></script>
</head>
<body>
<div class="container">
   <!-- Sign In -->
   <div class="container__form container--signin">
      <form action="${pageContext.request.contextPath }/member/login" class="form" id="form2" name="signinForm" method="post">
         <h2 class="form__title">Sign In</h2>
         <input type="text" placeholder="ID" class="input" name="id" required/>
         <input type="password" placeholder="Password" class="input" name="pw" required/>
         <span style="color:red; font-size:12px;">${requestScope.msg }</span>
         <button class="btn" id="signin-btn">Sign In</button>
      </form>
   </div>
   <!-- Sign Up -->
   <div class="container__form container--signup">
      <form action="#" class="form" id="form1" name="signupForm" >
         <h2 class="form__title">Sign Up</h2>
         <input type="text" placeholder="User" class="input" />
         <input type="email" placeholder="Email" class="input" />
         <input type="password" placeholder="Password" class="input" />
         <button class="btn">Sign Up</button>
      </form>
   </div>


   <!-- Overlay -->
   <div class="container__overlay">
      <div class="overlay">
         <div class="overlay__panel overlay--left">
            <button class="btn" id="signIn">Sign In</button>
         </div>
         <div class="overlay__panel overlay--right">
            <button class="btn" id="signUp">Sign Up</button>
         </div>
      </div>
   </div>
</div>
</body>
</html>