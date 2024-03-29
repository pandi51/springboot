package com.websocket.server.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.websocket.server.component.MyWebSocketHandler;

@RestController
public class WebSocketController {

	@Autowired
	MyWebSocketHandler handler;

	@GetMapping(path = "/wbsocket/server")
	public String websocketController() {
		return "Websocket server !!!";
	}

	@GetMapping("/websocket-server/send/{message}")
	public String sendMessage(@PathVariable("message") String msg) throws IOException {
		handler.sendMessage(msg);
		return "success";
	}

}