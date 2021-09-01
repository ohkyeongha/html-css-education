package com.kitri.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler{
	
	private Map<String, WebSocketSession> socketList = new HashMap<String, WebSocketSession>();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//웹소켓 연결 시 동작
		//onopen
//		System.out.println("afterConnectionEstablished 실행");
		socketList.put(session.getId(), session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//웹소켓 클라이언트가 메시지 전송할 때 동작
		//onmessage
//		System.out.println("handleTextMessage 실행");
//		System.out.println(message.getPayload());
		for(WebSocketSession userSession : socketList.values()) {//Map을 Collcetion으로 만들어주기 위해 .values()를 사용 -> 향상된 for문 사용 가능
			userSession.sendMessage(message);
		}
//		session.sendMessage(message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//웹소켓 종료시 동작
		//onclose
//		System.out.println("afterConnectionClosed 실행");
		socketList.remove(session.getId());
		
	}
	
}
