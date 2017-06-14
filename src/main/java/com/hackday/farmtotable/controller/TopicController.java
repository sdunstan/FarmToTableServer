package com.hackday.farmtotable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.hackday.farmtotable.model.Greeting;
import com.hackday.farmtotable.model.HelloMessage;

@Controller
public class TopicController {

	@Autowired
	private RestTemplate restTemplate;
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting sendGreeting(HelloMessage message) throws Exception {
		System.out.println((String) restTemplate.getForObject("http://localhost:8090/test", String.class));
		Thread.sleep(1000);
		return new Greeting("Hello " + message.getName() + " from topic controller!!!");
	}
}
