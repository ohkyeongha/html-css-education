<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script>
	window.onload = function(){
		var ajaxBtn = document.getElementById("ajaxBtn");
		var dataBtn = document.getElementById("dataBtn");
		
		dataBtn.onclick = function(){
			var text = document.getElementById("text");
			text.innerHTML = "데이터 수정됨";
		}
		
		ajaxBtn.onclick = function(){
			
			var xhr = new XMLHttpRequest();
			xhr.open("GET","ajax-server", true);
			xhr.send();
			
			xhr.onreadystatechange = function(){
				//응답 성공
				if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
					var text = document.getElementById("text");
					//응답 값 (서버로 부터 받아온 데이터)
					text.innerHTML = xhr.responseText;					
					
				}
			}
		}
		
		var ajaxPostBtn = document.getElementById("ajaxPostBtn");
		ajaxPostBtn.onclick = function(){
			//xmlhttprequest 객체 생성(ajax 통신 위한 객체)
			var xhrpost = new XMLHttpRequest();
			
			//통신할 메소드방식, url, 동기여부
			xhrpost.open("POST","ajax-server", true);
			//post요청을 하기위한 header 세팅
			xhrpost.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//요청
			xhrpost.send("id=admin&name=관리자");
			
			//응답
			xhrpost.onreadystatechange = function(){
				if(xhrpost.readyState == XMLHttpRequest.DONE && xhrpost.status == 200){
					var jsonStr = xhrpost.responseText;//json
					var json = JSON.parse(jsonStr);
					
					var jsonBox = document.getElementById("json-box");
					
					var html ="";
					for(var i=0; i < json.length; i++){
						html += "<div> id : "+json[i].id+"</div> "
						        +"<div> name : "+json[i].name+"</div>";
						
					}
					
					jsonBox.innerHTML = html;
					
				}
			}
			
			
		}
		
		
	}

</script>

</head>
<body>
	<button id="ajaxBtn">ajax get 통신</button>
	<button id="ajaxPostBtn">ajax post 통신</button>
	
	<button id="dataBtn">데이터 수정</button>
	<div id="text"></div>
	<div id="json-box"></div>
</body>
</html>

<title>AJAX TEST</title>
<script type="text/javascript">
window.onload = function(){
	var getBtn = document.getElementById("getBtn");
	var postBtn = document.getElementById("postBtn");
	var dataBtn = document.getElementById("dataBtn");
	
	dataBtn.onclick = function(){
		var text = document.getElementById("text");
		text.innerHTML = "수정완료";
	}
	
	getBtn.onclick = function(){
		var xhrget = new XMLHttpRequest();
		xhrget.open("GET","ajax-server", true);
		xhrget.send();
		
		xhrget.onreadystatechange = function(){
			//응답 성공
			if(xhrget.readyState == XMLHttpRequest.DONE && xhrget.status == 200){
				//응답값 (서버로부터 받아온 데이터)
				var text = document.getElementById("text");
				text.innerHTML = xhrget.responseText;
				
			}
		}
	}
	postBtn.onclick = function(){
		var xhrpost = new XMLHttpRequest();
		//통신할 메소드 방식, url, 동기여부
		xhrpost.open("POST","ajax-server", true);
		//post요청을 하기 위한 header세팅
		xhrpost.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		//요청
		xhrpost.send("id=admin&name=관리자");
		
		xhrpost.onreadystatechange = function(){
			//응답 성공
			if(xhrpost.readyState == XMLHttpRequest.DONE && xhrpost.status == 200){
				//응답값 (서버로부터 받아온 데이터)
				var jsonStr = xhrpost.responseText;
				var json = JSON.parse(jsonStr);
				
				var jsonBox = document.getElementById("json-box");
				
				var html="";
				for(var i=0; i<json.length; i++){
					html += "<div> id : "+json[i].id+"</div> "
						+"<div> name : "+json[i].name+"</div>";
				}
				jsonBox.innerHTML = html;
				
			}
		}
	}
}
</script>
</head>
<body>
	<button id="getBtn">ajax get 통신</button>
	<button id="postBtn">ajax post 통신</button>
	<button id="dataBtn">데이터 수정</button>
	<div id="text"></div>
	<div id="json-box"></div>
</body>
</html>

