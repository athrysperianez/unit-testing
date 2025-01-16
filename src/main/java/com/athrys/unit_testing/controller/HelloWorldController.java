package com.athrys.unit_testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hiiiii :3";
	}
	
}
