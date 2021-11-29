package com.example.tripadvisor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class TestHello {

	
		@GetMapping("/hello")
		public String hello() {
			return "Hello";
		}
}
