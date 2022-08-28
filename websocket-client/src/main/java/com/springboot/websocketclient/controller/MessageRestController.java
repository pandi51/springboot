package com.springboot.websocketclient.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.websocketclient.component.WebSocketClient;

@RestController
public class MessageRestController {

	@Autowired
	WebSocketClient client;

	@GetMapping("/websocket-client/send/{message}")
	public String sendMessage(@PathVariable("message") String msg) throws IOException {
		client.sendMessage(msg);
		return "success";
	}
}
