package com.hackday.farmtotable.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hackday.farmtotable.enums.SkillType;
import com.hackday.farmtotable.intent.IntentDeterminator;
import com.hackday.farmtotable.skilldata.SkillData;
import com.hackday.farmtotable.skilldata.SkillDataCreator;
import com.hackday.farmtotable.skilldata.SkillDataCreatorFactory;

@RestController
public class SpeechController {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SpeechController.class);
	
	private IntentDeterminator intentDeterminator;
	private SimpMessagingTemplate messagingTemplate;
	private SkillDataCreatorFactory skillDataCreatorFactory;
	private Gson gson;
	
	@Autowired
	public SpeechController(IntentDeterminator intentDeterminator, SimpMessagingTemplate messagingTemplate, SkillDataCreatorFactory skillDataCreatorFactory, Gson gson) {
		this.intentDeterminator = intentDeterminator;
		this.messagingTemplate = messagingTemplate;
		this.skillDataCreatorFactory = skillDataCreatorFactory;
		this.gson = gson;
	}
	
	@PostMapping("/message")
	public ResponseEntity<Void> post(@RequestBody String data) {
		SkillType type = intentDeterminator.determineIntent(data);
		SkillDataCreator dataCreator = skillDataCreatorFactory.get(type);
		SkillData skillData = dataCreator.create(data);
		LOGGER.info(skillData.toString());
		messagingTemplate.convertAndSend("/topic/" + type.getTypeStr(), gson.toJson(skillData));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
