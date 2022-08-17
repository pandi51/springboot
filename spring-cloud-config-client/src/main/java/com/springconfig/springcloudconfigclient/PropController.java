package com.springconfig.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PropController {

	@Value("${prop1:test value}")
	private String prop;

	@GetMapping("/msg")
	public String getMsg() {
		return this.prop;
	}

}
