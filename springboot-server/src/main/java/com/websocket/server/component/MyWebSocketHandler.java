package com.websocket.server.component;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler{

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		TextMessage message = new TextMessage("Hello from server******");
		session.sendMessage(message);
		System.out.println("session "+ session);
	} 

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("Message "+ message);
	}
}
