package com.hackday.farmtotable.intent;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.hackday.farmtotable.enums.SkillType;

@Component
public class IntentDeterminator {

	public SkillType determineIntent(Object message) {
		String data = (String) message;
		if (StringUtils.containsIgnoreCase(data, "meeting")) {
			return SkillType.MEETING;
		}
		return SkillType.UNKNOWN;
	}
}
