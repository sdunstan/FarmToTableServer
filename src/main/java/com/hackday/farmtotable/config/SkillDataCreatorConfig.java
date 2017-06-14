package com.hackday.farmtotable.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.hackday.farmtotable.enums.SkillType;
import com.hackday.farmtotable.skilldata.GoogleCreator;
import com.hackday.farmtotable.skilldata.MeetingCreator;
import com.hackday.farmtotable.skilldata.SkillDataCreator;
import com.hackday.farmtotable.skilldata.SportsCreator;

@Configuration
public class SkillDataCreatorConfig {

	@Bean
	public Gson gson() {
		return new Gson();
	}
	
	@Bean
	public Map<SkillType, SkillDataCreator> creators() {
		Map<SkillType, SkillDataCreator> creators = new HashMap<>();

		creators.put(SkillType.MEETING, new MeetingCreator());
		creators.put(SkillType.SPORTS, new SportsCreator());
		creators.put(SkillType.GOOGLE, new GoogleCreator());
		
		return creators;
	}
	
}
