package com.hackday.farmtotable.intent;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hackday.farmtotable.enums.SkillType;
import com.hackday.farmtotable.skilldata.SkillDataCreatorFactory;

@Component
public class IntentDeterminator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IntentDeterminator.class);
	
	public SkillType determineIntent(Object message) {
		String data = (String) message;
		LOGGER.info(data);
		if (StringUtils.containsIgnoreCase(data, "meeting")) {
			return SkillType.MEETING;
		}
		return SkillType.UNKNOWN;
	}
}
