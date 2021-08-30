<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//json으로 데이터 바꾸기
	window.onload = function(){
	
		const btn = document.getElementById("btn");
		
		btn.onclick = function(){
			let id = document.getElementById("id");
			let pw = document.getElementById("pw");
			let name = document.getElementById("name");
			let email = document.getElementById("email");
		
			//위의 요소들을 json으로 바꾸는 객체 생성(id는 객체이므로 이의 값인 value를 잊지말기)
			let jsonForm = new Object;
			jsonForm.id = id.value;
			jsonForm.pw = pw.value;
			jsonForm.name = name.value;
			jsonForm.email = email.value;
		
			let json = JSON.stringify(jsonForm);
// 			console.log(json);
			
			//ajax
			let xhr = new XMLHttpRequest();
			xhr.open("POST","reqbody",true);
			//post,json
			xhr.setRequestHeader("Content-type","application/json");
			xhr.send(json); //위에서 만든 json데이터를 send에 실어주면 됨
			
			xhr.onreadystatechange = function(){
	            if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
	               //성공
	                  alert("성공");
	               	  let jsonResult = xhr.responseText; //컨트롤러에서 받은 값을 콘솔로 확인
	               	  console.log(jsonResult);
	               		
	               }
			
			
			
		}
		
		
		
		
		
	}
	
	}

</script>
</head>
<body>
				<!-- body에 실어가는 것은 post만 가능하기 때문에 -->
	<form action="reqbody" method="post">
		아이디:<input type="text" name="id" id="id"> <br>
		패스워드:<input type="password" name="pw" id="pw"> <br>
		이름:<input type="text" name="name" id="name"> <br>
		이메일:<input type="text" name="email" id="email"> <br>
		
		<input type="button" id="btn" value="전송">
	</form>
	
</body>
</html>