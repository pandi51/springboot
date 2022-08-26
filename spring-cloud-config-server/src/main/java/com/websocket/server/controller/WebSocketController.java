package com.websocket.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

	
	@GetMapping(path = "/wbsocket/server")
	public String websocketController(){
		return "Websocket server !!!" ;
	}
}
