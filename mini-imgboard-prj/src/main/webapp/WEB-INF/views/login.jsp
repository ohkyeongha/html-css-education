<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script><!-- 라이브러리 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript">
// window.onload=function(){ 내용 }
// $(function(){ 내용 });
$(document).ready(function(){
// 	$("선택자")
	let loginBtn = $("#loginBtn");
 	//loginBtn.onclick = funtion(){ 내용 }
	//loginBtn.onclick(function(){ 내용 }));
	loginBtn.on("click", function(){
		let id = $("#id").val();
		let pw = $("#pw").val();
		
		if(id == ""){
			alert("아이디를 입력하세요.");
			return;
		}
		if(pw == ""){
			alert("비밀번호를 입력하세요.");
			return;
		}
		
		$.ajax({
			url: "${pageContext.request.contextPath}/user/logincheck",
			type : "post",
			data : {"id" : id , "pw": pw},
			dataType :"json",
			success:function(data){
				if(data){
					window.location.replace("${pageContext.request.contextPath}/main");
				} else {
// 					let loginMsg = $("#loginMsg");
// 					loginMsg.text("아이디 또는 비밀번호가 일치하지 않습니다. 다시 확인 해주세요.");

					$("#loginMsg").css("color", "red");
					$("#loginMsg").text("아이디 또는 비밀번호가 일치하지 않습니다.");
				}
			}, error:function(request, status, error){
				
			}
		});
		
	});
});
</script>

<style type="text/css">

fieldset {
	margin:0 auto;
	width: 400px;
	text-align: center;
	
}
fieldset div {
	margin:8px;
	min-height: 25px; 
}
input[type=text], input[type=password]{
	width: 250px;
}
</style>

</head>
<body>
	<fieldset>
		<h1>LOGIN</h1>
<%-- 		<form action="${pageContext.request.contextPath }/user/logincheck" method="post"> --%>
			<div>
				<input type="text" name="id" id="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="pw" id="pw" placeholder="비밀번호">
			</div>
			<div>
				<input type="button" name="loginBtn" id="loginBtn" value="로그인"> <a href="${pageContext.request.contextPath}/user/signup">회원가입</a>
			</div>
			<div>
				<span id="loginMsg"></span>
			</div>
<!-- 		</form> -->
		<div id="naver_id_login"></div>
	
	</fieldset>

	<script type="text/javascript">
		var naver_id_login = new naver_id_login("3GfhG6iS96I4TxoXfL4a",
				"http://localhost:8080/mini/user/naverlogin");
		var state = naver_id_login.getUniqState();
		naver_id_login.setButton("green", 3, 40);
		naver_id_login.setDomain("http://localhost:8080/mini/user/login");
		naver_id_login.setState(state);
// 		naver_id_login.setPopup();
		naver_id_login.init_naver_id_login();
	</script>
</body>
</html>