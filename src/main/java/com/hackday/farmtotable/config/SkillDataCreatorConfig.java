package com.hackday.farmtotable.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hackday.farmtotable.enums.SkillType;
import com.hackday.farmtotable.skilldata.MeetingCreator;
import com.hackday.farmtotable.skilldata.SkillDataCreator;
import com.hackday.farmtotable.skilldata.SportsCreator;

@Configuration
public class SkillDataCreatorConfig {

	@Bean
	public Map<SkillType, SkillDataCreator> creators() {
		Map<SkillType, SkillDataCreator> creators = new HashMap<>();

		creators.put(SkillType.MEETING, new MeetingCreator());
		creators.put(SkillType.SPORTS, new SportsCreator());
		
		return creators;
	}
	
}
