package com.websocket.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.websocket.server.component.MyWebSocketHandler;

@Configuration
@EnableWebSocket
public class MyWebSocketServerConfiguration implements WebSocketConfigurer {

	@Autowired
	MyWebSocketHandler webSocketHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		System.out.println("Handler....");
		registry.addHandler(webSocketHandler, "/websocket/server/demo");
	}

}
