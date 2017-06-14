package com.hackday.farmtotable.enums;

public enum SkillType {
	MEETING("meetings"),
	SPORTS("sports"),
	GOOGLE("google");

	private String typeStr;
	
	private SkillType(String typeStr) {
		this.typeStr = typeStr;
	}
	
	public String getTypeStr() {
		return typeStr;
	}
}
