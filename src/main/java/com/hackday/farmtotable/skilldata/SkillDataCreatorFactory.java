package com.hackday.farmtotable.skilldata;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackday.farmtotable.enums.SkillType;

@Component
public class SkillDataCreatorFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(SkillDataCreatorFactory.class);
	
	private Map<SkillType, SkillDataCreator> creators;
	
	@Autowired
	public SkillDataCreatorFactory(Map<SkillType, SkillDataCreator> creators) {
		this.creators = creators;
	}
	
	public SkillDataCreator get(SkillType type) {
		LOGGER.info("Skill Data Creator Factory: get type = " + type);
		return creators.get(type);
	}
	
}
