package com.hackday.farmtotable.skilldata;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackday.farmtotable.enums.SkillType;

@Component
public class SkillDataCreatorFactory {

	private Map<SkillType, SkillDataCreator> creators;
	
	@Autowired
	public SkillDataCreatorFactory(Map<SkillType, SkillDataCreator> creators) {
		this.creators = creators;
	}
	
	public SkillDataCreator get(SkillType type) {
		return creators.get(type);
	}
	
}
