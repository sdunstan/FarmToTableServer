package com.hackday.farmtotable.intent;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hackday.farmtotable.enums.SkillType;

@Component
public class IntentDeterminator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IntentDeterminator.class);
	
	private RestTemplate restTemplate;
	
	@Autowired
	public IntentDeterminator(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public SkillType determineIntent(Object message) {
		String data = (String) message;
		LOGGER.info(data);
		if (StringUtils.containsIgnoreCase(data, "meeting")) {
			return SkillType.MEETING;
		} else if(StringUtils.containsIgnoreCase(data, "sports")) {
			return SkillType.SPORTS;
		}
		return SkillType.UNKNOWN;
	}
}
