<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGNUP</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#signupBtn").on("click",function(){
			let id = $("#id").val();
			let pw = $("#pw").val();
			let name = $("#name").val();
			let email = $("#email").val();
			
			if(id=="" || id==null){
				alert("아이디를 입력하세요.");
				id.focus();
				return;
			}
			if(pw=="" || pw==null){
				alert("비밀번호를 입력하세요.");
				pw.focus();
				return;
			}
			if(name=="" || name==null){
				alert("이름을 입력하세요.");
				name.focus();
				return;
			}
			if(email=="" || email==null){
				alert("이메일 입력하세요.");
				email.focus();
				return;
			}
			
			$.ajax({
				url: "${path }/user/idcheck",
				type: "post",
				data: {"id" : id},/* id=admin post 데이터 전송 */
				dataType: "json",
				success:function(data){
// 					console.log(data);

					if(data){
						$("#signupForm").submit();
					} else {
						$("#idcheckMsg").css("color","red");
						$("#idcheckMsg").text("아이디가 존재합니다");		
					}
					
				}, 
				error:function(request, status, error ){
					console.log(error);
				}
			});
		});
	});
	
</script>


</head>
<body>
<fieldset>
	<h1>SIGNUP</h1>
	<form action="${path }/user/signup-regist" id="signupForm" method="post" >
		<div><input type="text" id="id" name="id" placeholder="아이디"></div>
		<div><input type="password" id="pw" name="pw" placeholder="비밀번호"></div>
		<div><input type="text" id="name" name="name" placeholder="이름"></div>
		<div><input type="text" id="email" name="email" placeholder="이메일"></div>
		<input type="button" id="signupBtn" value="가입"><span id="idcheckMsg">
	</form>
</fieldset>
</body>
</html>