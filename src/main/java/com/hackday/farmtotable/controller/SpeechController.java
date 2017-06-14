package com.hackday.farmtotable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackday.farmtotable.intent.IntentDeterminator;
import com.hackday.farmtotable.model.Greeting;

@RestController
public class SpeechController {

	private IntentDeterminator intentDeterminator;
	private SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	public SpeechController(IntentDeterminator intentDeterminator, SimpMessagingTemplate messagingTemplate) {
		this.intentDeterminator = intentDeterminator;
		this.messagingTemplate = messagingTemplate;
	}
	
	@PostMapping("/message")
	public ResponseEntity<Void> post(@RequestBody String data) {
		intentDeterminator.determineIntent(data);
		messagingTemplate.convertAndSend("/topic/greetings", new Greeting("Hello from speech controller!!!"));
		return new ResponseEntity<>(HttpStatus.OK);
		//return new ResponseEntity<SkillType>(intentDeterminator.determineIntent(data), HttpStatus.OK);
	}
}
