package com.hackday.farmtotable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackday.farmtotable.enums.SkillType;
import com.hackday.farmtotable.intent.IntentDeterminator;
import com.hackday.farmtotable.model.Greeting;
import com.hackday.farmtotable.skilldata.SkillData;
import com.hackday.farmtotable.skilldata.SkillDataCreator;
import com.hackday.farmtotable.skilldata.SkillDataCreatorFactory;

@RestController
public class SpeechController {

	private IntentDeterminator intentDeterminator;
	private SimpMessagingTemplate messagingTemplate;
	private SkillDataCreatorFactory skillDataCreatorFactory;
	
	@Autowired
	public SpeechController(IntentDeterminator intentDeterminator, SimpMessagingTemplate messagingTemplate, SkillDataCreatorFactory skillDataCreatorFactory) {
		this.intentDeterminator = intentDeterminator;
		this.messagingTemplate = messagingTemplate;
		this.skillDataCreatorFactory = skillDataCreatorFactory;
	}
	
	@PostMapping("/message")
	public ResponseEntity<Void> post(@RequestBody String data) {
		SkillType type = intentDeterminator.determineIntent(data);
		if(type == SkillType.UNKNOWN) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		SkillDataCreator dataCreator = skillDataCreatorFactory.get(type);
		SkillData skillData = dataCreator.create(data);
		messagingTemplate.convertAndSend("/topic/greetings", skillData);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
