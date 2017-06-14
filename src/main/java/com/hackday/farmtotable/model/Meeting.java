package com.hackday.farmtotable.model;

import com.hackday.farmtotable.enums.SkillType;

public class Meeting implements Skill {

	@Override
	public Object getMessage() {
		return "this is a message";
	}

	@Override
	public SkillType getSkillType() {
		return SkillType.MEETING;
	}

}
