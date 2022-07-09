package com.silver0r.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silver0r.api.dto.TestResponse;

@RestController
public class TestController {
	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse test(@CookieValue("sc-lb-instance-id") String instanceId) {
		return TestResponse.builder()
			.id(instanceId)
			.value("1234")
			.build();
	}
}
