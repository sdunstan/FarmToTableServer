package com.hackday.farmtotable.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	@RequestMapping("/test")
	public String test() {
		return "rest test";
	}
}
