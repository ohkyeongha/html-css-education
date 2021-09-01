<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAVER LOGIN</title>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<!-- <script type="text/javascript" -->
<!-- 	src="http://code.jquery.com/jquery-1.11.3.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script><!-- 라이브러리 -->
<body>
	<script type="text/javascript">
		var naver_id_login = new naver_id_login("3GfhG6iS96I4TxoXfL4a",
				"http://localhost:8080/mini/user/naverlogin");
		// 접근 토큰 값 출력
		//   alert(naver_id_login.oauthParams.access_token);
		// 네이버 사용자 프로필 조회
		naver_id_login.get_naver_userprofile("naverSignInCallback()");
		// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
		function naverSignInCallback() {
			//     alert(naver_id_login.getProfileData('email'));
			//     alert(naver_id_login.getProfileData('name'));
			//     alert(naver_id_login.getProfileData('birthday'));
			//     alert(naver_id_login.getProfileData('mobile'));

			let user = new Object();
			user.name = naver_id_login.getProfileData('name');
			user.email = naver_id_login.getProfileData('email');
			user.birthday = naver_id_login.getProfileData('birthday');
			user.mobile = naver_id_login.getProfileData('mobile');

			//jquery를 사용하기 위해서는 라이브러리 필요함 (직접 다운 , cdn)
			//javascript dom객체(html요소 div, h1, span)를 편리하게 사용하기 위한 라이브러리
			//javascript 예) document.getElementById("id");
			//jQuery	 예) $(선택자) ID -> $("#id")
			//						class->${".class"}
			//						tag -> $("tag")
			$.ajax({
		         url: "${pageContext.request.contextPath}/user/naverlogincheck",   // 이동할 url 값
		         type: "POST",   // method POST, GET
		         data: JSON.stringify(user),   // url로 이동시킬 데이터 값
		         dataType: "json",   // 데이터 타입 설정 (json, xml)
		         contentType: "application/json",
		         success:function(data) {
		            console.log(data);
		            
		            window.location.replace("${pageContext.request.contextPath}/main");
		         }, 
		         error: function(request, status, error) {
					console.log("code:" + request.status);
					console.log("message:" + request.responseText);
					console.log("error:" + error);
		            window.location.replace("${pageContext.request.contextPath}/user/login");
		         }
		      });
		}
	</script>
</body>
</html>