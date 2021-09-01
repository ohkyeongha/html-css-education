<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Socket</title>

<script type="text/javascript">
let webSocket;
let id;
window.onload = function(){
	const connect = document.getElementById("connect");
	const disconnect = document.getElementById("disconnect");
	const send = document.getElementById("send");
	const chatbox = document.getElementById("chatbox");
	connect.onclick = openWebSocket;
	disconnect.onclick = closeWebSocket;
// 	send.onclick = sendMessage;
	msg.onkeyup = sendMessage;
}

function sendMessage(event){
	if(msg.value==""){
		return;
		}
	if(event.keyCode==13 || event == null){
		let msg = document.getElementById("msg");
		if(webSocket==null){
			alert("채팅방에 입장하세요");
			id.focus();
			msg.value="";
			return;
		}
		
		webSocket.send("[" + id.value + "] " +msg.value);
		msg.value="";
		msg.focus();
	} 
}

function closeWebSocket(){
	webSocket.send("[" + id.value + "] 님께서 접속을 종료하셨습니다.");
	webSocket.close();
}

function openWebSocket(){
	id = document.getElementById("id");
	if(id.value == ""){
		alert("id를 입력하세요.");
		id.focus();
		return;
	} 
	webSocket = new WebSocket("ws://192.168.0.201:8080/websocket/ws");
	webSocket.onopen = onOpen;
	webSocket.onmessage = onMessage;
	webSocket.onclose = onClose;
}

function onOpen(){
// 	id = document.getElementById("id");
	alert(id.value+"님 환영합니다.");
	
	//msg 전달 -> handler -> handlerTextMessage 호출
	webSocket.send("["+id.value +"] 님이 입장했습니다.");
	
}

function onMessage(event){	//session.sendMessage(메시지 값); 호출되면 실행
	console.log(event);
// 	alert(event.data);
	
	chatbox.innerHTML += "<span>" + event.data + "</span><br>";
	chatbox.scrollTop = chatbox.scrollHeight;
}

function onClose(){
	chatbox.innerHTML = "";
	id.value="";
	alert("접속 종료");
	
}

</script>

<style type="text/css">
body {
/* 	background-color: black; */
}
fieldset {
	margin: 16px auto;
	width: 320px;
	text-align: center;
	background-color: white;
	border: 1px solid black;
	border-radius: 8px;
	
}
#chatbox {
	text-align:left;
	overflow:auto;
	margin: 0 auto;
	width: 300px;
	height: 300px;
	border: 1px solid black;
}
input[type=button]{
	background-color: hotpink;
	color: white;
	border: 1px solid hotpink;
	border-radius: 2px;
}

</style>

</head>
<body>
	<fieldset>
		<div id="connctionArea">
			<label>ID : <input type="text" name="id" id="id"></label>
			<input type="button" id="connect" value="입장">
			<input type="button" id="disconnect" value="나가기">
		</div id="chatArea">
			<h1>채팅창</h1>
			<div id="chatbox" class="scroll"></div>
			<input type="text" id="msg">
			<input type="button" id="send" value="전송">
		<div>
		</div>
	</fieldset>
	
</body>
</html>