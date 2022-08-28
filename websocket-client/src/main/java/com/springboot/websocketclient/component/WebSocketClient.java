package com.springboot.websocketclient.component;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Component
public class WebSocketClient {

	@Autowired
	WebsocketClientHandler handler;

	public static String wsUri = "wss://localhost:8888/websocket/server/demo";

	WebSocketSession webSocketSession;
	
	@Qualifier("wssSSLContext")
	@Autowired
	SSLContext sslContext;

	@PostConstruct
	public void init() throws InterruptedException, ExecutionException {
		StandardWebSocketClient swsc = new StandardWebSocketClient();
		swsc.getUserProperties().put("org.apache.tomcat.websocket.SSL_CONTEXT", sslContext);

		WebSocketHttpHeaders header = new WebSocketHttpHeaders();

		ListenableFuture<WebSocketSession> doHandshake = swsc.doHandshake(handler, header, URI.create(wsUri));
		webSocketSession = doHandshake.get();
	}

	public void sendMessage(String msg) throws IOException {
		TextMessage msgObj = new TextMessage(msg.getBytes());
		webSocketSession.sendMessage(msgObj);
	}
}
